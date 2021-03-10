package com.newsapp.business.top_stories.executer

import com.newsapp.business.top_stories.mapper.StoryModelToStoryMapper
import com.newsapp.business.top_stories.model.StoryModel
import com.newsapp.mapper.Mapper
import com.newsapp.remo_impl.StoryRepo
import com.newsapp.remo_impl.data.Story
import com.newsapp.thread.di.module.PostExecutionThread
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class BookmarkStoryExecutor @Inject constructor(
    private val storyRepo: StoryRepo,
    private val mapper: StoryModelToStoryMapper,
    postExecutionThread: PostExecutionThread
) :
    com.newsapp.thread.di.module.FlowExecutor<StoryModel, Boolean>(postExecutionThread) {

    override fun execute(params: StoryModel?): Flow<Boolean> {
        return if (params == null)
            flowOf(false)
        else
            storyRepo.bookmarkStory(mapper.mapFrom(params))
    }
}