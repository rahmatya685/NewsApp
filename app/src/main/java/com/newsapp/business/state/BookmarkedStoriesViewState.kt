package com.newsapp.business.state

import com.newsapp.business.model.StoryModel

class BookmarkedStoriesViewState(
    val stories: List<StoryModel>,
    val loadingMsg: String? = null,
    val errorMsg: String? = null
) : ViewState {

    val isLoading: Boolean
        get() = loadingMsg != null

    val hasError: Boolean
        get() = errorMsg != null

    val hasStories: Boolean
        get() = stories.isNotEmpty()

    companion object {
        val initState: BookmarkedStoriesViewState
            get() = BookmarkedStoriesViewState(
                stories = mutableListOf()
            )
    }
}