package com.newsapp.di.module

import com.newsapp.views.ImageLoader
import com.newsapp.views.ImageLoaderImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
interface ImageLoaderModule {

    @get:[Binds Singleton]
    val com.newsapp.views.ImageLoaderImpl.imageLoader: com.newsapp.views.ImageLoader
}
