package com.newsapp.remo_impl.di.module

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
    val StoryRepoImpl.topStoriesRep: StoryRepo

}