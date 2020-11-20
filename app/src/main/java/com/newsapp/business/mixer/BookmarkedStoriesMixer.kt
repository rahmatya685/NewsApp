package com.newsapp.business.mixer

import com.newsapp.business.results.BookmarkedStoriesViewResult
import com.newsapp.business.results.TopStoriesViewResult
import com.newsapp.business.state.BookmarkedStoriesViewState
import com.newsapp.business.state.TopStoriesViewState
import javax.inject.Inject

class BookmarkedStoriesMixer  @Inject constructor() :
    ResultStateMixer<BookmarkedStoriesViewResult, BookmarkedStoriesViewState> {
    override fun mix(
        result: BookmarkedStoriesViewResult,
        oldState: BookmarkedStoriesViewState
    ): BookmarkedStoriesViewState {
        return when (result) {
            BookmarkedStoriesViewResult.Loading -> BookmarkedStoriesViewState(
                stories = mutableListOf(),
                loadingMsg = "Loading",
                errorMsg = null
            )
            is BookmarkedStoriesViewResult.Success -> BookmarkedStoriesViewState(
                stories = result.data,
                loadingMsg = null,
                errorMsg = null
            )
            is BookmarkedStoriesViewResult.Failure -> BookmarkedStoriesViewState(
                stories = mutableListOf(),
                errorMsg = result.error,
                loadingMsg = null
            )
        }
    }
}