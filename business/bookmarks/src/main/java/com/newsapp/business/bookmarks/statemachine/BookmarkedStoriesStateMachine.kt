package com.newsapp.business.bookmarks.statemachine

import com.newsapp.business.bookmarks.actions.BookmarkedStoriesAction
import com.newsapp.business.bookmarks.results.BookmarkedStoriesViewResult
import com.newsapp.business.bookmarks.state.BookmarkedStoriesViewState
import com.newsapp.business.bookmarks.BookmarkedStoriesActionProcessorType
import com.newsapp.business.bookmarks.BookmarkedStoriesMixerType
import com.newsapp.core_business.state_machine.ViewStateMachine
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