package com.newsapp.business.executor

import com.newsapp.business.model.StoryModel
import com.newsapp.repository.StoryRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class BookmarkStoryExecutor @Inject constructor(
    private val storyRepo: StoryRepo,
    postExecutionThread: PostExecutionThread
) :
    FlowExecutor<StoryModel,Boolean>(postExecutionThread) {

    override fun execute(params: StoryModel?): Flow<Boolean> {
        return storyRepo.bookmarkStory(params)
    }
}