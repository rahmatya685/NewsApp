package com.newsapp.repository.local.topstories

import javax.inject.Inject

class BookmarkedStoriesRepoImpl @Inject constructor(
    val bookmarkedEntityDao: BookmarkedEntityDao
) : BookmarkedStoriesRepo {


}