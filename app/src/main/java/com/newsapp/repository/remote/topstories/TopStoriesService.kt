package com.newsapp.repository.remote.topstories

import com.newsapp.repository.dto.TopStoriesDto
import com.newsapp.util.Constants
import retrofit2.http.GET

interface TopStoriesService {

    @GET("home.json?api-key=" + Constants.TOKEN)
    suspend fun loadTopStories(): TopStoriesDto

}