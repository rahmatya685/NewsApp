package com.newsapp.remo_impl.remote.topstories

import com.newsapp.remo_impl.dto.TopStoriesDto
import javax.inject.Inject

class TopStoriesApiImpl @Inject constructor(
    private val service: TopStoriesService
) : TopStoriesApi {

    override suspend fun loadTopStories(): TopStoriesDto = service.loadTopStories()

}