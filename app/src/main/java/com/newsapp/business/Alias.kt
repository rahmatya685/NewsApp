package com.newsapp.business

import com.newsapp.business.actions.TopStoriesAction
import com.newsapp.business.mixer.ResultStateMixer
import com.newsapp.business.processor.ActionProcessor
import com.newsapp.business.results.TopStoriesViewResult
import com.newsapp.business.state.TopStoriesViewState


typealias TopStoriesActionProcessorType =
        @JvmSuppressWildcards
        ActionProcessor<TopStoriesAction, TopStoriesViewResult>

typealias TopStoriesMixerType =
        @JvmSuppressWildcards
        ResultStateMixer<TopStoriesViewResult, TopStoriesViewState>