package com.newsapp.remo_impl.di.module

import com.newsapp.remo_impl.BuildConfig
import com.newsapp.remo_impl.remote.base.RetrofitCreator
import com.newsapp.remo_impl.remote.topstories.TopStoriesApi
import com.newsapp.remo_impl.remote.topstories.TopStoriesApiImpl
import com.newsapp.remo_impl.remote.topstories.TopStoriesService
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface NetModule {


    @get:[Binds Singleton]
    val TopStoriesApiImpl.bindRemote: TopStoriesApi


    companion object {
        @Singleton
        @Provides
        fun provideTopStoriesService(): TopStoriesService =
            RetrofitCreator(BuildConfig.NTYMES_URL)
                .build().create(TopStoriesService::class.java)
    }

}
