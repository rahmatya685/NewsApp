package com.newsapp.remo_impl.remote.topstories

import com.newsapp.remo_impl.Constants
import com.newsapp.remo_impl.dto.TopStoriesDto
import retrofit2.http.GET

interface TopStoriesService {

    @GET("home.json?api-key=" + Constants.TOKEN)
    suspend fun loadTopStories(): TopStoriesDto

}