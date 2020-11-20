package com.newsapp.di.component

import com.newsapp.business.executor.PostExecutionThread
import com.newsapp.navigation.NavigationDispatcher
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent


@EntryPoint
@InstallIn(ActivityComponent::class)
interface AppComponent {
    val navigationDispatcher: NavigationDispatcher
    val postExecutionThread: PostExecutionThread
}