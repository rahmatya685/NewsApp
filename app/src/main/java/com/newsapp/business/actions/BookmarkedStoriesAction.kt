package com.newsapp.business.actions

sealed class BookmarkedStoriesAction : ViewAction {
    object LoadStories : BookmarkedStoriesAction()
}