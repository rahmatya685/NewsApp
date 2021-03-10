package com.newsapp.business.bookmarks.executor

import com.newsapp.business.bookmarks.model.Bookmark
import com.newsapp.remo_impl.StoryRepo
import com.newsapp.thread.di.module.PostExecutionThread
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class UnBookmarkStoryExecutor @Inject constructor(
    private val postExecutionThread: PostExecutionThread,
    private val storyRepo: StoryRepo,
) : com.newsapp.thread.di.module.FlowExecutor<Bookmark, Boolean>(postExecutionThread) {
    override fun execute(params: Bookmark?): Flow<Boolean> =
        if (params == null)
            flowOf(false)
        else
            storyRepo.unBookmarkStory(params.id)
}