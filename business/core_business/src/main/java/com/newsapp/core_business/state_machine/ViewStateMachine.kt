package com.newsapp.core_business.state_machine

import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.flow.*

abstract class ViewStateMachine<A : com.newsapp.core_business.actions.ViewAction, S : com.newsapp.core_business.state.ViewState, R : com.newsapp.core_business.result.ViewResult> constructor(
    private val actionProcessor: com.newsapp.core_business.processor.ActionProcessor<A, R>,
    private val mixer: com.newsapp.core_business.mixer.ResultStateMixer<R, S>,
    private val initialViewState: S,
    private val initialAction: A
) {

    private val viewStateFlow: MutableStateFlow<S> = MutableStateFlow(initialViewState)

    val viewState: StateFlow<S>
        get() = viewStateFlow


    private val intentsChannel: ConflatedBroadcastChannel<A> =
        ConflatedBroadcastChannel(initialAction)

    fun processActions(actions: Flow<A>): Flow<A> = actions.onEach { viewAction ->
        intentsChannel.offer(viewAction)
    }

    val processor: Flow<S> = intentsChannel.asFlow()
        .flatMapMerge { action ->
            actionProcessor.actionToResult(action)
        }.scan(initialViewState) { previous, result ->
            mixer.mix(result, previous)
        }.distinctUntilChanged()
        .onEach { recipeViewState ->
            viewStateFlow.value = recipeViewState
        }
}