package com.newsapp.business.bookmarks.state

import com.newsapp.business.bookmarks.model.Bookmark
import com.newsapp.core_business.state.ViewState


class BookmarkedStoriesViewState(
    val stories: List<Bookmark>,
    val currentBookmark: Bookmark? = null,
    val loadingMsg: String? = null,
    val errorMsg: String? = null,
    val successMsg: String? = null
) : ViewState {

    val isLoading: Boolean
        get() = loadingMsg != null

    val hasError: Boolean
        get() = errorMsg != null

    val showSuccess: Boolean
        get() = successMsg != null

    val hasStories: Boolean
        get() = stories.isNotEmpty()

    val showDetail: Boolean
        get() = currentBookmark != null

    companion object {
        val initState: BookmarkedStoriesViewState
            get() = BookmarkedStoriesViewState(
                stories = mutableListOf()
            )
    }
}