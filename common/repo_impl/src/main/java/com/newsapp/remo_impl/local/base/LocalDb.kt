package com.newsapp.remo_impl.local.base

import androidx.room.Database
import androidx.room.RoomDatabase
import com.newsapp.remo_impl.local.topstories.BookmarkedEntityDao
import com.newsapp.remo_impl.local.topstories.BookmarkedEntity


const val DB_Version = 9
const val DB_NAME = "Db"
@Database(entities = [BookmarkedEntity::class], version = DB_Version)
abstract class LocalDb : RoomDatabase() {
    abstract fun bookmarkedEntityDao(): BookmarkedEntityDao
}