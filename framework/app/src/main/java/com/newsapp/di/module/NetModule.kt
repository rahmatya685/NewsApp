package com.newsapp.di.module

import com.newsapp.remo_impl.remote.base.RetrofitCreator
import com.newsapp.remo_impl.remote.topstories.TopStoriesApi
import com.newsapp.remo_impl.remote.topstories.TopStoriesApiImpl
import com.newsapp.remo_impl.remote.topstories.TopStoriesService
import com.newsapp.remo_impl.Constants
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
interface NetModule {


    @get:[Binds Singleton]
    val TopStoriesApiImpl.bindRemote: TopStoriesApi


    companion object {
        @Singleton
        @Provides
        fun provideTopStoriesService(): TopStoriesService =
            RetrofitCreator(Constants.URL)
                .build().create(TopStoriesService::class.java)
    }

}