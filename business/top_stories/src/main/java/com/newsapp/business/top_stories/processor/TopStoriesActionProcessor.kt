package com.newsapp.business.top_stories.processor

import com.newsapp.business.top_stories.action.TopStoriesAction
import com.newsapp.business.top_stories.executer.BookmarkStoryExecutor
import com.newsapp.business.top_stories.executer.FetchTopStoriesExecutor
import com.newsapp.business.top_stories.model.StoryModel
import com.newsapp.business.top_stories.result.TopStoriesViewResult
import com.newsapp.core_business.processor.ActionProcessor
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class TopStoriesActionProcessor @Inject constructor(
    private val storyFetcher: FetchTopStoriesExecutor,
    private val bookmarkStory: BookmarkStoryExecutor
) :
    ActionProcessor<TopStoriesAction, TopStoriesViewResult> {

    private val stories: Flow<List<StoryModel>>
        get() = storyFetcher()

    override fun actionToResult(viewAction: TopStoriesAction): Flow<TopStoriesViewResult> {
        return when (viewAction) {
            is TopStoriesAction.LoadStories -> getNewStories
            is TopStoriesAction.BookmarkStory ->
                bookmarkStoryModel(
                    viewAction.storyModel
                )
            is TopStoriesAction.ShowDetail -> flowOf(
                TopStoriesViewResult.ShowDetail(viewAction.storyModel)
            )
        }
    }

    private fun bookmarkStoryModel(storyModel: StoryModel): Flow<TopStoriesViewResult> =
        bookmarkStory(storyModel).map { saved ->
            if (saved)
                TopStoriesViewResult.Bookmarked(storyModel)
            else
                TopStoriesViewResult.Failure("Already Bookmarked")
        }.onStart {
            emit(TopStoriesViewResult.Loading)
        }.catch { error ->
            emit(TopStoriesViewResult.Failure(error = error.toString()))
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