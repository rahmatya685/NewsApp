package com.newsapp.business.statemachine

import com.newsapp.business.BookmarkedStoriesActionProcessorType
import com.newsapp.business.BookmarkedStoriesMixerType
import com.newsapp.business.actions.BookmarkedStoriesAction
import com.newsapp.business.results.BookmarkedStoriesViewResult
import com.newsapp.business.state.BookmarkedStoriesViewState
import javax.inject.Inject

class BookmarkedStoriesStateMachine @Inject constructor(
    actionProcessor: BookmarkedStoriesActionProcessorType,
    mixer: BookmarkedStoriesMixerType
) :
    ViewStateMachine<BookmarkedStoriesAction, BookmarkedStoriesViewState, BookmarkedStoriesViewResult>(
        actionProcessor, mixer,
        BookmarkedStoriesViewState.initState,
        BookmarkedStoriesAction.LoadStories
    )