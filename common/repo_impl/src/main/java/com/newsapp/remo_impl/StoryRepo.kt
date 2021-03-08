package com.newsapp.remo_impl

import com.newsapp.remo_impl.data.Story
import kotlinx.coroutines.flow.Flow

interface StoryRepo {
    fun getNewStories(): Flow<List<Story>>
    fun getBookmarkedStories(): Flow<List<Story>>
    fun bookmarkStory(params: Story?): Flow<Boolean>
    fun unBookmarkStory(id:Int): Flow<Boolean>
}