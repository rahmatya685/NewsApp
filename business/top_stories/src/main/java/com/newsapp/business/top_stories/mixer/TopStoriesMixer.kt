package com.newsapp.business.top_stories.mixer

import com.newsapp.business.top_stories.result.TopStoriesViewResult
import com.newsapp.business.top_stories.state.TopStoriesViewState
import com.newsapp.core_business.event.ViewEvent
import com.newsapp.core_business.mixer.ResultStateMixer
import javax.inject.Inject

class TopStoriesMixer @Inject constructor() :
    ResultStateMixer<TopStoriesViewResult, TopStoriesViewState> {
    override fun mix(
        result: TopStoriesViewResult,
        oldState: TopStoriesViewState
    ): TopStoriesViewState {
        return when (result) {
            TopStoriesViewResult.Loading -> TopStoriesViewState(
                stories = mutableListOf(),
                loadingMsg = "Loading",
                errorMsg = null,
                bookmarkedStory = null,
                showStoryDetail = null
            )
            is TopStoriesViewResult.Success -> TopStoriesViewState(
                stories = result.data,
                loadingMsg = null,
                errorMsg = null,
                bookmarkedStory = null,
                showStoryDetail = null
            )
            is TopStoriesViewResult.Failure -> TopStoriesViewState(
                stories = mutableListOf(),
                loadingMsg = null,
                errorMsg = result.error,
                bookmarkedStory = null,
                showStoryDetail = null
            )
            is TopStoriesViewResult.Bookmarked -> TopStoriesViewState(
                stories = oldState.stories,
                errorMsg = null,
                loadingMsg = null,
                bookmarkedStory = ViewEvent(result.data),
                showStoryDetail = null
            )
            is TopStoriesViewResult.ShowDetail ->
                oldState.openStoryDetailState(result.data)
        }
    }
}