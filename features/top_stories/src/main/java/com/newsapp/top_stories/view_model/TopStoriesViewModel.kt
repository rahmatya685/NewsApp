package com.newsapp.top_stories.view_model

import androidx.lifecycle.*
import com.newsapp.business.top_stories.action.TopStoriesAction
import com.newsapp.business.top_stories.state.TopStoriesViewState
import com.newsapp.business.top_stories.state_machine.TopStoriesStateMachine
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

    fun processAction(actions: TopStoriesAction) {
        stateMachine.processActions(actions)
    }

}