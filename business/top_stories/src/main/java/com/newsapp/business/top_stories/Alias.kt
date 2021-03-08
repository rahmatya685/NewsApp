package com.newsapp.business.top_stories

import com.newsapp.business.top_stories.action.TopStoriesAction
import com.newsapp.core_business.mixer.ResultStateMixer
import com.newsapp.core_business.processor.ActionProcessor
import com.newsapp.business.top_stories.result.TopStoriesViewResult
import com.newsapp.business.top_stories.state.TopStoriesViewState


typealias TopStoriesActionProcessorType =
        @JvmSuppressWildcards
        ActionProcessor<TopStoriesAction, TopStoriesViewResult>

typealias TopStoriesMixerType =
        @JvmSuppressWildcards
        ResultStateMixer<TopStoriesViewResult, TopStoriesViewState>



