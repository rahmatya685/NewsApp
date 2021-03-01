package com.newsapp.di.module

import com.newsapp.repository.StoryRepo
import com.newsapp.repository.StoryRepoImpl
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