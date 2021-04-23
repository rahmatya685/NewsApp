package com.newsapp.business.top_stories.action

import com.newsapp.business.top_stories.model.StoryModel
import com.newsapp.core_business.actions.ViewAction

sealed class TopStoriesAction : ViewAction {
    object LoadStories : TopStoriesAction()
    data class BookmarkStory(val storyModel: StoryModel) :
        TopStoriesAction()

    data class ShowDetail(val storyModel: StoryModel) : TopStoriesAction()
}