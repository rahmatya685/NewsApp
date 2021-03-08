package com.newsapp.business.top_stories.executer

 import com.newsapp.business.top_stories.model.StoryModel
import com.newsapp.core_business.executor.FlowExecutor
import com.newsapp.core_business.executor.PostExecutionThread
import com.newsapp.mapper.Mapper
import com.newsapp.remo_impl.StoryRepo
import com.newsapp.remo_impl.data.Story
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class BookmarkStoryExecutor @Inject constructor(
    private val storyRepo: StoryRepo,
    private val mapper: Mapper<StoryModel?, Story>,
    postExecutionThread: PostExecutionThread
) :
    FlowExecutor<StoryModel,Boolean>(postExecutionThread) {

    override fun execute(params: StoryModel?): Flow<Boolean> {
        return storyRepo.bookmarkStory(mapper.mapFrom(params))
    }
}