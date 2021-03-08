package com.newsapp.remo_impl.remote.topstories

import com.newsapp.remo_impl.dto.TopStoriesDto

interface TopStoriesApi {
    suspend fun loadTopStories(): TopStoriesDto
}