package com.newsapp.core_business.state_machine

import com.newsapp.core_business.actions.ViewAction
import com.newsapp.core_business.mixer.ResultStateMixer
import com.newsapp.core_business.processor.ActionProcessor
import com.newsapp.core_business.result.ViewResult
import com.newsapp.core_business.state.ViewState
import kotlinx.coroutines.ExperimentalCoroutinesApi
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


    @ExperimentalCoroutinesApi
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
        .onEach { newViewState ->
            viewStateFlow.value = newViewState
        }
}