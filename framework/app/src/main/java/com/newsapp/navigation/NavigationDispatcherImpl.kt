package com.newsapp.navigation

import androidx.core.os.bundleOf
import androidx.navigation.NavController
import com.newsapp.R
import com.newsapp.story_details.ui.STORY_KEY
import javax.inject.Inject


//TODO move this class to navigation module and add deep link navigation
class NavigationDispatcherImpl @Inject constructor(
    private val navController: NavController
) : NavigationDispatcher {

    override fun goBack() {
        navController.navigateUp()
    }

    override fun openStoryDetail(storyModel: Any) {
        navController.navigate(
            R.id.storyDetail,
            bundleOf(STORY_KEY to storyModel)
        )
    }

    override fun openBookmarkDetail(b: Any) {

    }

}