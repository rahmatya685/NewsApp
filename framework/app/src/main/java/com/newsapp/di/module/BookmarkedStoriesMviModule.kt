package com.newsapp.di.module


import com.newsapp.business.bookmarks.mixer.BookmarkedStoriesMixer
import com.newsapp.business.bookmarks.processor.BookmarkedStoriesActionProcessor
import com.newsapp.di.FeatureScope
import dagger.Binds
import dagger.Module
import dagger.hilt.migration.DisableInstallInCheck

@DisableInstallInCheck
@Module
interface BookmarkedStoriesMviModule {


    @get:[Binds FeatureScope]
    val BookmarkedStoriesActionProcessor.actionProcessor: BookmarkedStoriesActionProcessorType

    @get:[Binds FeatureScope]
    val BookmarkedStoriesMixer.mixer: BookmarkedStoriesMixerType
}