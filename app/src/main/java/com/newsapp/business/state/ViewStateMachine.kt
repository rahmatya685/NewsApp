package com.newsapp.business.state

import com.newsapp.business.actions.ViewAction
import com.newsapp.business.mixer.ResultStateMixer
import com.newsapp.business.processor.ActionProcessor
import com.newsapp.business.results.ViewResult
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.flow.*

abstract class ViewStateMachine<A : ViewAction, S : ViewState, R : ViewResult> constructor(
    private val actionProcessor: ActionProcessor<A, R>,
    private val mixer: ResultStateMixer<R, S>,
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