package com.newsapp.repository.remote.topstories

import android.media.session.MediaSession
import com.newsapp.repository.dto.TopStoriesDto
import com.newsapp.util.Constants
import retrofit2.http.GET

interface TopStoriesService {


    @GET("/home.json?api-key=" + Constants.TOKEN)
    fun loadTopStories(): TopStoriesDto

}