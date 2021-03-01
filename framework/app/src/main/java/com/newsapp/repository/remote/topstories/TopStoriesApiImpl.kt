package com.newsapp.repository.remote.topstories

import com.newsapp.repository.dto.TopStoriesDto
import javax.inject.Inject

class TopStoriesApiImpl @Inject constructor(
    private val service: TopStoriesService
) : TopStoriesApi {

    override suspend fun loadTopStories(): TopStoriesDto = service.loadTopStories()

}