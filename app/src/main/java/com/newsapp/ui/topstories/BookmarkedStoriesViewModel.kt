package com.newsapp.ui.topstories

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.newsapp.business.actions.BookmarkedStoriesAction
import com.newsapp.business.state.BookmarkedStoriesViewState
import com.newsapp.business.statemachine.BookmarkedStoriesStateMachine
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.launchIn
import javax.inject.Inject

class BookmarkedStoriesViewModel @Inject constructor(
    private val stateMachine: BookmarkedStoriesStateMachine
) : ViewModel() {

    val viewState: LiveData<BookmarkedStoriesViewState> = stateMachine.viewState.asLiveData()

    init {
        stateMachine.processor.launchIn(viewModelScope)
    }

    fun processAction(actions: Flow<BookmarkedStoriesAction>) {
        stateMachine
            .processActions(actions)
            .launchIn(viewModelScope)
    }

}