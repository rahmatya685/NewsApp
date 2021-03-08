package com.newsapp.navigation

import com.newsapp.business.bookmarks.model.Bookmark
import com.newsapp.business.top_stories.model.StoryModel

interface NavigationDispatcher {
    fun goBack()
    fun openStoryDetail(storyModel: StoryModel)
    fun openBookmarkDetail(b:  Bookmark)
}