package com.newsapp.repository.local.topstories


interface BookmarkedStoriesRepo {
    suspend fun getBookmarkedStories(): List<BookmarkedEntity>
}