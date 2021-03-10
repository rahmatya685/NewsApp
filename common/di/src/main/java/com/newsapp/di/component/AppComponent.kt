package com.newsapp.di.component

import com.newsapp.navigation.NavigationDispatcher
import com.newsapp.thread.di.module.PostExecutionThread
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent


@EntryPoint
@InstallIn(ActivityComponent::class)
interface AppComponent {
    val navigationDispatcher: NavigationDispatcher
    val postExecutionThread: PostExecutionThread
}