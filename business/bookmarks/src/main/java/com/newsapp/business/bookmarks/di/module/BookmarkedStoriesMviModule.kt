package com.newsapp.business.bookmarks.di.module


import com.newsapp.business.bookmarks.BookmarkedStoriesActionProcessorType
import com.newsapp.business.bookmarks.BookmarkedStoriesMixerType
import com.newsapp.business.bookmarks.mapper.StoryToBookmarkMapper
import com.newsapp.business.bookmarks.mixer.BookmarkedStoriesMixer
import com.newsapp.business.bookmarks.model.Bookmark
import com.newsapp.business.bookmarks.processor.BookmarkedStoriesActionProcessor
import com.newsapp.di.FeatureScope
import com.newsapp.mapper.Mapper
import com.newsapp.remo_impl.data.Story
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

    @get:[Binds FeatureScope]
    val StoryToBookmarkMapper.mapper: Mapper<Story, Bookmark>
}