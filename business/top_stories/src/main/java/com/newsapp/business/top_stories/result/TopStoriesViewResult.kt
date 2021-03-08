package com.newsapp.business.top_stories.result

import com.newsapp.business.top_stories.model.StoryModel
import com.newsapp.core_business.result.ViewResult

sealed class TopStoriesViewResult : ViewResult {
    data class Success(val data: List<StoryModel>) : TopStoriesViewResult()
    data class Bookmarked(val data: StoryModel) : TopStoriesViewResult()
    data class ShowDetail(val data: StoryModel) : TopStoriesViewResult()
    data class Failure(val error: String) : TopStoriesViewResult()
    object Loading : TopStoriesViewResult()
}