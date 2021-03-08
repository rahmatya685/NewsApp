package com.newsapp.business.bookmarks.results

import com.newsapp.business.bookmarks.model.Bookmark
import com.newsapp.core_business.result.ViewResult

sealed class BookmarkedStoriesViewResult : ViewResult {
    data class Success(val data: List<Bookmark>) : BookmarkedStoriesViewResult()
    data class DeleteBookmarkSuccess(val data: Bookmark) : BookmarkedStoriesViewResult()
    data class Failure(val error: String) : BookmarkedStoriesViewResult()
    data class ShowDetail(val data: Bookmark) : BookmarkedStoriesViewResult()
    object Loading : BookmarkedStoriesViewResult()
}