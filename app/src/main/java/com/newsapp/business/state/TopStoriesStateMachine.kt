package com.newsapp.business.state

import com.newsapp.business.*
import com.newsapp.business.actions.TopStoriesAction
import com.newsapp.business.results.TopStoriesViewResult
import javax.inject.Inject

class TopStoriesStateMachine @Inject constructor(
    actionProcessor: TopStoriesActionProcessorType,
    mixer: TopStoriesMixerType
) :
    ViewStateMachine<TopStoriesAction, TopStoriesViewState, TopStoriesViewResult>(
        actionProcessor, mixer, TopStoriesViewState.initState, TopStoriesAction.LoadStories
    )