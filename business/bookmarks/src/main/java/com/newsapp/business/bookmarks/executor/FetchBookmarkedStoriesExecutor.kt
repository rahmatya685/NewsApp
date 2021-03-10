package com.newsapp.business.bookmarks.executor

import com.newsapp.business.bookmarks.mapper.StoryToBookmarkMapper
import com.newsapp.business.bookmarks.model.Bookmark
import com.newsapp.mapper.Mapper
import com.newsapp.remo_impl.StoryRepo
import com.newsapp.remo_impl.data.Story
import com.newsapp.thread.di.module.FlowExecutor
import com.newsapp.thread.di.module.PostExecutionThread
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class FetchBookmarkedStoriesExecutor @Inject constructor(
    private val storyRepo: StoryRepo,
    private val bookmarkMapper: StoryToBookmarkMapper,
    postExecutionThread: PostExecutionThread
) :
    FlowExecutor<Unit, List<Bookmark>>(postExecutionThread) {

    override fun execute(params: Unit?): Flow<List<Bookmark>> {
        return storyRepo.getBookmarkedStories().map {
            bookmarkMapper.mapList(it)
        }
    }
}