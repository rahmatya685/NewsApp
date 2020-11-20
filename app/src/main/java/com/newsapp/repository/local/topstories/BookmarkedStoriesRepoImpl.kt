package com.newsapp.repository.local.topstories

 import javax.inject.Inject

class BookmarkedStoriesRepoImpl @Inject constructor(
    private val bookmarkedEntityDao: BookmarkedEntityDao
) : BookmarkedStoriesRepo {

    override suspend fun getBookmarkedStories(): List<BookmarkedEntity> =
        bookmarkedEntityDao.getBookmarkedStories()

}