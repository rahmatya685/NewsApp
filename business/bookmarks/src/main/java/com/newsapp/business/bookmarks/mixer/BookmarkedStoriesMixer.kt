package com.newsapp.business.bookmarks.mixer

import com.newsapp.business.bookmarks.results.BookmarkedStoriesViewResult
import com.newsapp.business.bookmarks.state.BookmarkedStoriesViewState
import com.newsapp.core_business.mixer.ResultStateMixer
import javax.inject.Inject

class BookmarkedStoriesMixer @Inject constructor() :
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
            is BookmarkedStoriesViewResult.DeleteBookmarkSuccess -> BookmarkedStoriesViewState(
                stories = mutableListOf(),
                errorMsg = null,
                loadingMsg = null,
                successMsg = "Delete Successfully"
            )
            is BookmarkedStoriesViewResult.ShowDetail -> BookmarkedStoriesViewState(
                stories = mutableListOf(),
                errorMsg = null,
                loadingMsg = null,
            )
        }
    }
}