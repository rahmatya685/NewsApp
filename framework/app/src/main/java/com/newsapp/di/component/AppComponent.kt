package com.newsapp.di.component

import com.newsapp.navigation.NavigationDispatcher
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent


@EntryPoint
@InstallIn(ActivityComponent::class)
interface AppComponent {
    val navigationDispatcher: com.newsapp.navigation.NavigationDispatcher
    val postExecutionThread: com.newsapp.core_business.executor.PostExecutionThread
}