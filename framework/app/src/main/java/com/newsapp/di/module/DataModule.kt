package com.newsapp.di.module

import com.newsapp.remo_impl.StoryRepo
import com.newsapp.remo_impl.StoryRepoImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
interface DataModule {

    @get:[Binds Singleton]
    val com.newsapp.remo_impl.StoryRepoImpl.topStoriesRep: com.newsapp.remo_impl.StoryRepo

}