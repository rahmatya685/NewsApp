package com.newsapp.navigation

import com.newsapp.business.model.StoryModel

interface NavigationDispatcher {
    fun goBack()
    fun openStoryDetail(storyModel: StoryModel)
}