package com.newsapp.business.results

import com.newsapp.business.model.StoryModel

sealed class TopStoriesViewResult : ViewResult {
    data class Success(val data: List<StoryModel>) : TopStoriesViewResult()
    data class Bookmarked(val data:StoryModel) : TopStoriesViewResult()
    data class ShowDetail(val data:StoryModel) : TopStoriesViewResult()
    data class Failure(val error: String) : TopStoriesViewResult()
    object Loading : TopStoriesViewResult()
}