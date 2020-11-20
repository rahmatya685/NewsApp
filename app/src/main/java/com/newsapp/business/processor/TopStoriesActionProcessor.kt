package com.newsapp.business.processor

import com.newsapp.business.actions.TopStoriesAction
import com.newsapp.business.executor.FetchTopStoriesExecutor
import com.newsapp.business.model.StoryModel
import com.newsapp.business.results.TopStoriesViewResult
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class TopStoriesActionProcessor @Inject constructor(
    private val storyFetcher: FetchTopStoriesExecutor
) :
    ActionProcessor<TopStoriesAction, TopStoriesViewResult> {

    private val stories: Flow<List<StoryModel>>
        get() = storyFetcher()

    override fun actionToResult(viewAction: TopStoriesAction): Flow<TopStoriesViewResult> {
        return when (viewAction) {
            TopStoriesAction.LoadStories -> getNewStories
            TopStoriesAction.LoadSavedStories -> emptyFlow()
        }
    }


    private val getNewStories: Flow<TopStoriesViewResult>
        get() = stories.map {
            if (it.isEmpty()) {
                TopStoriesViewResult.Failure("No Data Found")
            } else {
                TopStoriesViewResult.Success(it)
            }
        }.onStart {
            emit(TopStoriesViewResult.Loading)
        }.catch { error ->
            emit(TopStoriesViewResult.Failure(error = error.toString()))
        }
}