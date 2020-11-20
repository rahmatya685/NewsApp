package com.newsapp.business.mixer

import com.newsapp.business.results.TopStoriesViewResult
import com.newsapp.business.state.TopStoriesViewState
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
                bookmarkedStory = null
            )
            is TopStoriesViewResult.Success -> TopStoriesViewState(
                stories = result.data,
                loadingMsg = null,
                errorMsg = null,
                bookmarkedStory = null
            )
            is TopStoriesViewResult.Failure -> TopStoriesViewState(
                stories = mutableListOf(),
                loadingMsg = null,
                errorMsg = result.error,
                bookmarkedStory = null
            )
            is TopStoriesViewResult.Bookmarked -> TopStoriesViewState(
                stories = oldState.stories,
                errorMsg = null,
                loadingMsg = null,
                bookmarkedStory = result.data
            )
        }
    }
}