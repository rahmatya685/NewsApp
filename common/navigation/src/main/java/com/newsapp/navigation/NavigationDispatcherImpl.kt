package com.newsapp.navigation

import android.content.Context
import android.net.Uri
import androidx.core.net.toUri
import androidx.navigation.NavController
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.NavOptions
import androidx.navigation.NavOptionsBuilder
import dagger.hilt.android.qualifiers.ActivityContext
import javax.inject.Inject


class NavigationDispatcherImpl @Inject constructor(
    private val navController: NavController,
    @ActivityContext private val context: Context
) : NavigationDispatcher {

    override fun goBack() {
        navController.navigateUp()
    }

    override fun openStoryDetail(url: String, title: String) {

        val pTitleValue = context.getString(R.string.par_title_value)
        val pUrlValue = context.getString(R.string.par_url_value)

        val path = context.getString(R.string.story_detail_fragment_link)
            .replace(pUrlValue, url)
            .replace(pTitleValue, title)
        val navoptions =NavOptions.Builder()
            .setLaunchSingleTop(true)
            .build()
        navController.navigate(path.toUri(),navoptions)
    }

    override fun openBookmarkDetail(storyId: Int) {
        val path = context.getString(R.string.story_detail_fragment_id)
            .replace("id", storyId.toString())
        Uri.parse(path)?.let {
            navController.navigate(it)
        }
    }

}