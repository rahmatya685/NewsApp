package com.newsapp.navigation


interface NavigationDispatcher {
    fun goBack()
    fun openStoryDetail(storyModel: Any)
    fun openBookmarkDetail(b:  Any)
}