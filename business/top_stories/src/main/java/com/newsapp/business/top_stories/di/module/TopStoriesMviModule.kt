package com.newsapp.business.top_stories.di.module


import com.newsapp.business.top_stories.TopStoriesActionProcessorType
import com.newsapp.business.top_stories.TopStoriesMixerType
import com.newsapp.business.top_stories.mapper.StoryToStoryModelMapper
import com.newsapp.business.top_stories.mixer.TopStoriesMixer
import com.newsapp.business.top_stories.model.StoryModel
import com.newsapp.business.top_stories.processor.TopStoriesActionProcessor
import com.newsapp.di.FeatureScope
import com.newsapp.mapper.Mapper
import com.newsapp.remo_impl.data.Story
import dagger.Binds
import dagger.Module
import dagger.hilt.migration.DisableInstallInCheck


@DisableInstallInCheck
@Module
interface TopStoriesMviModule {

    @get:[Binds FeatureScope]
    val TopStoriesActionProcessor.actionProcessor: TopStoriesActionProcessorType

    @get:[Binds FeatureScope]
    val TopStoriesMixer.mixer: TopStoriesMixerType

    @get:[Binds FeatureScope]
    val StoryToStoryModelMapper.mapper2: Mapper<Story, StoryModel>
}