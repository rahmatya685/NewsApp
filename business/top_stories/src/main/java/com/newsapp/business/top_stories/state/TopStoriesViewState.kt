package com.newsapp.business.top_stories.state

import com.newsapp.business.top_stories.model.StoryModel
import com.newsapp.core_business.event.ViewEvent
import com.newsapp.core_business.state.ViewState

data class TopStoriesViewState(
    val stories: List<StoryModel>,
    val loadingMsg: String? = null,
    val errorMsg: String? = null,
    val bookmarkedStory: ViewEvent<StoryModel>? = null,
    val showStoryDetail: ViewEvent<StoryModel>? = null
) : ViewState {

    //TODO use states functions(loading, error, success) instead of variables

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

    fun openStoryDetailState(data: StoryModel): TopStoriesViewState = this.copy(
        stories = stories,
        errorMsg = null,
        loadingMsg = null,
        bookmarkedStory = null,
        showStoryDetail = ViewEvent(data)
    )

    companion object {

        val initState: TopStoriesViewState
            get() = TopStoriesViewState(
                stories = mutableListOf(),
                bookmarkedStory = null,
                showStoryDetail = null
            )
    }
}