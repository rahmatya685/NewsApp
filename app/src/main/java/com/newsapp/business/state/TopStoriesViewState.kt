package com.newsapp.business.state

import com.newsapp.business.model.StoryModel


data class TopStoriesViewState(
    val stories: List<StoryModel>,
    val loadingMsg: String? = null,
    val errorMsg: String? = null,
    val bookmarkedStory: StoryModel? = null,
    val showStoryDetail: StoryModel? = null
) : ViewState {


    val isLoading: Boolean
        get() = loadingMsg != null

    val hasError: Boolean
        get() = errorMsg != null

    val hasStories: Boolean
        get() = stories.isNotEmpty()

    val hasBookmarkedStory: Boolean
        get() = bookmarkedStory != null

    val hasStoryDetailToShow: Boolean
        get() = showStoryDetail != null

    companion object {
        val initState: TopStoriesViewState
            get() = TopStoriesViewState(
                stories = mutableListOf(),
                bookmarkedStory = null,
                showStoryDetail = null
            )
    }
}