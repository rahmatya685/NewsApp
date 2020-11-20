package com.newsapp.business.actions

import com.newsapp.business.model.StoryModel

sealed class TopStoriesAction:ViewAction{
    object LoadStories:TopStoriesAction()
    data class BookmarkStory(val storyModel: StoryModel):TopStoriesAction()

}