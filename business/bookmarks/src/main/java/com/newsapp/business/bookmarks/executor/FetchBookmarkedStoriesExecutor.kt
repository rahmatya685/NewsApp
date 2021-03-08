package com.newsapp.business.bookmarks.executor

import com.newsapp.business.bookmarks.mapper.BookmarkMapper
import com.newsapp.business.bookmarks.model.Bookmark
import com.newsapp.core_business.executor.FlowExecutor
import com.newsapp.core_business.executor.PostExecutionThread
import com.newsapp.mapper.Mapper
import com.newsapp.remo_impl.StoryRepo
import com.newsapp.remo_impl.data.Story
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class FetchBookmarkedStoriesExecutor @Inject constructor(
    private val storyRepo: StoryRepo,
    private val bookmarkMapper: Mapper<Story, Bookmark>,
    postExecutionThread: PostExecutionThread
) :
    FlowExecutor<Unit, List<Bookmark>>(postExecutionThread) {

    override fun execute(params: Unit?): Flow<List<Bookmark>> {
        return storyRepo.getBookmarkedStories().map {
            bookmarkMapper.mapList(it)
        }
    }
}