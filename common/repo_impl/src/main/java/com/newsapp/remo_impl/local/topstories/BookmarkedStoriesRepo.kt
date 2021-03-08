package com.newsapp.remo_impl.local.topstories


interface BookmarkedStoriesRepo {
    suspend fun getBookmarkedStories(): List<BookmarkedEntity>
    suspend fun bookmarkStory(params: BookmarkedEntity): Boolean
    suspend fun deleteBookmark(id:Int): Boolean
}