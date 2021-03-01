package com.newsapp.repository.remote.topstories

import com.newsapp.repository.dto.TopStoriesDto

interface TopStoriesApi {
    suspend fun loadTopStories(): TopStoriesDto
}