package com.newsapp.business.bookmarks.actions

import com.newsapp.business.bookmarks.model.Bookmark
import com.newsapp.core_business.actions.ViewAction

sealed class BookmarkedStoriesAction : ViewAction {
    object LoadStories : BookmarkedStoriesAction()
    data class UnBookmarkStory(val bookmark: Bookmark) : BookmarkedStoriesAction()
    data class ShowDetail(val bookmark: Bookmark) : BookmarkedStoriesAction()
}