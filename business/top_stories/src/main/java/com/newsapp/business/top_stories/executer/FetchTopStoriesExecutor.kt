package com.newsapp.business.top_stories.executer

import com.newsapp.business.top_stories.model.StoryModel
import com.newsapp.core_business.executor.FlowExecutor
import com.newsapp.core_business.executor.PostExecutionThread
import com.newsapp.mapper.Mapper
import com.newsapp.remo_impl.StoryRepo
import com.newsapp.remo_impl.data.Story
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class FetchTopStoriesExecutor @Inject constructor(
    private val storyRepo: StoryRepo,
    private val mapper: Mapper<Story,StoryModel>,
    postExecutionThread: PostExecutionThread
) :
    FlowExecutor<Unit, List<StoryModel>>(postExecutionThread) {

    override fun execute(params: Unit?): Flow<List<StoryModel>> {
        return storyRepo.getNewStories().map {
            mapper.mapList(it)
        }
    }
}