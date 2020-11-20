package com.newsapp.repository

import com.newsapp.business.model.StoryModel
import com.newsapp.repository.mapper.TopStoryRemoteMapper
import com.newsapp.repository.remote.topstories.TopStoriesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class StoryRepoImpl @Inject constructor(
    private val api: TopStoriesApi,
    private val mapper: TopStoryRemoteMapper
) : StoryRepo {
    override fun getNewStories(): Flow<List<StoryModel>> = flow {
        val dto = api.loadTopStories()
        emit(mapper.mapFromModel(dto))
    }
}