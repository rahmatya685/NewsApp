package com.newsapp.di.component

import com.newsapp.repository.StoryRepo
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@EntryPoint
@InstallIn(SingletonComponent::class)
interface CoreComponent {
//    val imageLoader: ImageLoader
    val storyRepo: StoryRepo
}
