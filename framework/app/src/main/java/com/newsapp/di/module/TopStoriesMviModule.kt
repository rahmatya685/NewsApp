package com.newsapp.di.module

import com.newsapp.business.TopStoriesActionProcessorType
import com.newsapp.business.TopStoriesMixerType
import com.newsapp.business.top_stories.mixer.TopStoriesMixer
import com.newsapp.business.top_stories.processor.TopStoriesActionProcessor
import com.newsapp.di.FeatureScope
import dagger.Binds
import dagger.Module
import dagger.hilt.migration.DisableInstallInCheck


@DisableInstallInCheck
@Module
interface TopStoriesMviModule {

    @get:[Binds FeatureScope]
    val com.newsapp.business.top_stories.processor.TopStoriesActionProcessor.actionProcessor: TopStoriesActionProcessorType

    @get:[Binds FeatureScope]
    val com.newsapp.business.top_stories.mixer.TopStoriesMixer.mixer: TopStoriesMixerType
}