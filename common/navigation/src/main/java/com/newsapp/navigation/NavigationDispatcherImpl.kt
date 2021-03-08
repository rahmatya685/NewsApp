package com.newsapp.navigation

import androidx.core.os.bundleOf
import androidx.navigation.NavController
import com.newsapp.business.bookmarks.model.Bookmark
import com.newsapp.business.top_stories.model.StoryModel
import javax.inject.Inject

class NavigationDispatcherImpl @Inject constructor(
    private val navController: NavController
) : NavigationDispatcher {

    override fun goBack() {
        navController.navigateUp()
    }

    override fun openStoryDetail(storyModel: StoryModel) {
        navController.navigate(
            R.id.storyDetail,
            bundleOf(STORY_KEY to storyModel)
        )
    }

    override fun openBookmarkDetail(b: Bookmark) {

    }

    companion object {
        const val STORY_KEY: String = "STORY_KEY"
    }
}