package com.newsapp.business.processor

import com.newsapp.business.actions.BookmarkedStoriesAction
import com.newsapp.business.executor.FetchBookmarkedStoriesExecutor
import com.newsapp.business.model.StoryModel
import com.newsapp.business.results.BookmarkedStoriesViewResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

class BookmarkedStoriesActionProcessor @Inject constructor(
    private val localStoryFetcher:FetchBookmarkedStoriesExecutor
) :
    ActionProcessor<BookmarkedStoriesAction, BookmarkedStoriesViewResult> {

    private val stories: Flow<List<StoryModel>>
        get() = localStoryFetcher()

    override fun actionToResult(viewAction: BookmarkedStoriesAction): Flow<BookmarkedStoriesViewResult> {
        return when (viewAction) {
            BookmarkedStoriesAction.LoadStories -> getLocalStories
        }
    }


    private val getLocalStories: Flow<BookmarkedStoriesViewResult>
        get() = stories.map {
            if (it.isEmpty()) {
                BookmarkedStoriesViewResult.Failure("No Data Found")
            } else {
                BookmarkedStoriesViewResult.Success(it)
            }
        }.onStart {
            emit(BookmarkedStoriesViewResult.Loading)
        }.catch { error ->
            emit(BookmarkedStoriesViewResult.Failure(error = error.toString()))
        }
}