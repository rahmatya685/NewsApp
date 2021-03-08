package com.newsapp.business.bookmarks.processor

import com.newsapp.business.bookmarks.actions.BookmarkedStoriesAction
import com.newsapp.business.bookmarks.executor.FetchBookmarkedStoriesExecutor
import com.newsapp.business.bookmarks.executor.UnBookmarkStoryExecutor
import com.newsapp.business.bookmarks.model.Bookmark
import com.newsapp.business.bookmarks.results.BookmarkedStoriesViewResult
import com.newsapp.core_business.processor.ActionProcessor
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class BookmarkedStoriesActionProcessor @Inject constructor(
    private val localStoryFetcher: FetchBookmarkedStoriesExecutor,
    private val unBookmarkStoryExecutor: UnBookmarkStoryExecutor
) : ActionProcessor<BookmarkedStoriesAction, BookmarkedStoriesViewResult> {

    private val stories: Flow<List<Bookmark>>
        get() = localStoryFetcher()


    override fun actionToResult(viewAction: BookmarkedStoriesAction):
            Flow<BookmarkedStoriesViewResult>
    {
        return when (viewAction) {
            is BookmarkedStoriesAction.LoadStories ->
                getLocalStories
            is BookmarkedStoriesAction.ShowDetail ->
                flowOf(BookmarkedStoriesViewResult.ShowDetail(viewAction.bookmark))
            is BookmarkedStoriesAction.UnBookmarkStory ->
                deleteBookmark(viewAction)
        }
    }

    private fun deleteBookmark(action: BookmarkedStoriesAction.UnBookmarkStory):
            Flow<BookmarkedStoriesViewResult> =
        unBookmarkStoryExecutor(action.bookmark)
            .map { result ->
                if (result)
                    BookmarkedStoriesViewResult.DeleteBookmarkSuccess(action.bookmark)
                else
                    BookmarkedStoriesViewResult.Failure("Unable to delete")
            }.onStart {
                emit(BookmarkedStoriesViewResult.Loading)
            }.catch { error ->
                emit(BookmarkedStoriesViewResult.Failure(error = error.toString()))
            }


    private val getLocalStories: Flow<BookmarkedStoriesViewResult>
        get() = stories.map {
            if (it.isEmpty()) {
                BookmarkedStoriesViewResult.Failure("No bookmarked story has found")
            } else {
                BookmarkedStoriesViewResult.Success(it)
            }
        }.onStart {
            emit(BookmarkedStoriesViewResult.Loading)
        }.catch { error ->
            emit(BookmarkedStoriesViewResult.Failure(error = error.toString()))
        }
}