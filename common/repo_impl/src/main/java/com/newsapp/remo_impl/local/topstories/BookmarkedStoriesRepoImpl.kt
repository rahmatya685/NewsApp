package com.newsapp.remo_impl.local.topstories

import javax.inject.Inject

class BookmarkedStoriesRepoImpl @Inject constructor(
    private val bookmarkedEntityDao: BookmarkedEntityDao
) : BookmarkedStoriesRepo {

    override suspend fun getBookmarkedStories(): List<BookmarkedEntity> =
        bookmarkedEntityDao.getBookmarkedStories()


    override suspend fun bookmarkStory(entity: BookmarkedEntity): Boolean {
        return if (bookmarkedEntityDao.isInsertedAlready(entity.title))
            false
        else {
            bookmarkedEntityDao.insert(entity)
            true
        }
    }

    override suspend fun deleteBookmark(id: Int): Boolean =
        bookmarkedEntityDao.delete(id)

}