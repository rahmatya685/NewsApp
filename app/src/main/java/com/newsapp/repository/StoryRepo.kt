package com.newsapp.repository

import com.newsapp.business.model.StoryModel
import kotlinx.coroutines.flow.Flow

interface StoryRepo {
    fun getNewStories(): Flow<List<StoryModel>>
}