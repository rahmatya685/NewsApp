package com.newsapp.navigation


interface NavigationDispatcher {
    fun goBack()
    fun openStoryDetail(url:String,title:String)
    fun openBookmarkDetail(storyId:Int)
}