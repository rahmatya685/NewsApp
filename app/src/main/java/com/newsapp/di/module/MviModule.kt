package com.newsapp.di.module

import com.newsapp.business.TopStoriesActionProcessorType
import com.newsapp.business.TopStoriesMixerType
import com.newsapp.business.mixer.TopStoriesMixer
import com.newsapp.business.processor.TopStoriesActionProcessor
import com.newsapp.di.FeatureScope
import dagger.Binds
import dagger.Module
import dagger.hilt.migration.DisableInstallInCheck


@DisableInstallInCheck
@Module
interface MviModule {

    @get:[Binds FeatureScope]
    val TopStoriesActionProcessor.actionProcessor: TopStoriesActionProcessorType

    @get:[Binds FeatureScope]
    val TopStoriesMixer.mixer: TopStoriesMixerType
}