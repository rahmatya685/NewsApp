package com.newsapp.ui.topstories

import androidx.lifecycle.*
import com.newsapp.business.actions.TopStoriesAction
import com.newsapp.business.state.TopStoriesStateMachine
import com.newsapp.business.state.TopStoriesViewState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.launchIn
import javax.inject.Inject

class TopStoriesViewModel @Inject constructor(
    private val stateMachine: TopStoriesStateMachine
) : ViewModel() {

    val viewState: LiveData<TopStoriesViewState> = stateMachine.viewState.asLiveData()

    init {
        stateMachine.processor.launchIn(viewModelScope)
    }

    fun processAction(actions: Flow<TopStoriesAction>) {
        stateMachine
            .processActions(actions)
            .launchIn(viewModelScope)
    }

}