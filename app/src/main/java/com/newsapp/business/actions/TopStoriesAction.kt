package com.newsapp.business.actions

sealed class TopStoriesAction:ViewAction{
    object LoadStories:TopStoriesAction()

}