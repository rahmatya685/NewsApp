package com.newsapp.business.bookmarks

import com.newsapp.business.bookmarks.state.BookmarkedStoriesViewState
import com.newsapp.business.bookmarks.actions.BookmarkedStoriesAction
import com.newsapp.business.bookmarks.results.BookmarkedStoriesViewResult
import com.newsapp.core_business.mixer.ResultStateMixer
import com.newsapp.core_business.processor.ActionProcessor


typealias BookmarkedStoriesActionProcessorType =
        @JvmSuppressWildcards
        ActionProcessor<BookmarkedStoriesAction, BookmarkedStoriesViewResult>

typealias BookmarkedStoriesMixerType =
        @JvmSuppressWildcards
        ResultStateMixer<BookmarkedStoriesViewResult, BookmarkedStoriesViewState>



