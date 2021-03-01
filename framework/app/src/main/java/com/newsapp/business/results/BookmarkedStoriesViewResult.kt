package com.newsapp.business.results

import com.newsapp.business.model.StoryModel

sealed class BookmarkedStoriesViewResult:ViewResult {
    data class Success(val data: List<StoryModel>) : BookmarkedStoriesViewResult()
    data class Failure(val error: String) : BookmarkedStoriesViewResult()
    object Loading : BookmarkedStoriesViewResult()
}