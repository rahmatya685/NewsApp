package com.newsapp.repository.local.topstories

import com.newsapp.business.model.StoryModel


interface BookmarkedStoriesRepo {
    suspend fun getBookmarkedStories(): List<BookmarkedEntity>
    suspend fun bookmarkStory(params: BookmarkedEntity): Boolean
}