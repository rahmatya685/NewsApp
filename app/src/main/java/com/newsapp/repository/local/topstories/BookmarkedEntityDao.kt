package com.newsapp.repository.local.topstories

import androidx.room.Dao
import androidx.room.Query
import com.newsapp.repository.local.base.BaseDao


@Dao
interface BookmarkedEntityDao : BaseDao<BookmarkedEntity> {


    @Query("Select * from BOOK_MARKED_ENTITY")
    suspend fun getBookmarkedStories(): List<BookmarkedEntity>

    @Query("Select exists(Select * from BOOK_MARKED_ENTITY where BOOK_MARKED_ENTITY.TITLE like :title)")
    suspend fun isInsertedAlready(title: String): Boolean
}