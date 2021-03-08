package com.newsapp.business.top_stories.state_machine

import com.newsapp.business.top_stories.TopStoriesActionProcessorType
import com.newsapp.business.top_stories.TopStoriesMixerType
import com.newsapp.business.top_stories.action.TopStoriesAction
import com.newsapp.business.top_stories.result.TopStoriesViewResult
import com.newsapp.business.top_stories.state.TopStoriesViewState
import com.newsapp.core_business.state_machine.ViewStateMachine
import javax.inject.Inject

class TopStoriesStateMachine @Inject constructor(
    actionProcessor: TopStoriesActionProcessorType,
    mixer: TopStoriesMixerType
) :
    ViewStateMachine<TopStoriesAction, TopStoriesViewState, TopStoriesViewResult>(
        actionProcessor,
        mixer,
        TopStoriesViewState.initState,
        TopStoriesAction.LoadStories
    )