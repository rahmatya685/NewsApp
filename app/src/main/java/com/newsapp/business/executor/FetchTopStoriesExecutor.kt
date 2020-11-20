package com.newsapp.business.executor

import com.newsapp.business.model.StoryModel
import com.newsapp.repository.StoryRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FetchTopStoriesExecutor @Inject constructor(
    private val storyRepo: StoryRepo,
    postExecutionThread: PostExecutionThread
) :
    FlowExecutor<Unit, List<StoryModel>>(postExecutionThread) {

    override fun execute(params: Unit?): Flow<List<StoryModel>> {
        return storyRepo.getNewStories()
    }
}