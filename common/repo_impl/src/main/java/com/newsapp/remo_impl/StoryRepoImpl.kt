package com.newsapp.remo_impl

import com.newsapp.remo_impl.data.Story
import com.newsapp.remo_impl.local.topstories.BookmarkedStoriesRepo
import com.newsapp.remo_impl.mapper.BookmarkedEntityMapper
import com.newsapp.remo_impl.mapper.BookmarkedStoryLocalMapper
import com.newsapp.remo_impl.mapper.TopStoryRemoteMapper
import com.newsapp.remo_impl.remote.topstories.TopStoriesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class StoryRepoImpl @Inject constructor(
    private val api: TopStoriesApi,
    private val localRepo: BookmarkedStoriesRepo,
    private val mapper: TopStoryRemoteMapper,
    private val bookmarkedStoryLocalMapper: BookmarkedStoryLocalMapper,
    private val bookmarkedEntityMapper: BookmarkedEntityMapper
) : StoryRepo {
    override fun getNewStories(): Flow<List<Story>> = flow {
        val dto = api.loadTopStories()
        emit(mapper.mapFrom(dto))
    }

    override fun getBookmarkedStories(): Flow<List<Story>> = flow {
        val bookmarkedStories = localRepo.getBookmarkedStories()
        emit(bookmarkedStoryLocalMapper.mapList(bookmarkedStories))
    }

    override fun bookmarkStory(params: Story?): Flow<Boolean> = flow {
        val entity = bookmarkedEntityMapper.mapFrom(params!!)
        val result = localRepo.bookmarkStory(entity)
        emit(result)
    }

    override fun unBookmarkStory(id: Int): Flow<Boolean> = flow {
        emit(localRepo.deleteBookmark(id))
    }


}