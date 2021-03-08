package com.newsapp.di

import com.newsapp.di.component.AppComponent
import com.newsapp.di.component.CoreComponent
import com.newsapp.di.component.DaggerStoriesComponent
import com.newsapp.top_stories.ui.TopStoriesFragment
import dagger.hilt.android.EntryPointAccessors

internal fun inject(fragment: com.newsapp.top_stories.ui.TopStoriesFragment) {
    DaggerStoriesComponent
        .factory()
        .create(coreComponent(fragment), appComponent(fragment))
        .inject(fragment)
}

private fun coreComponent(fragment: com.newsapp.top_stories.ui.TopStoriesFragment): CoreComponent =
    EntryPointAccessors.fromApplication(
        fragment.requireContext().applicationContext,
        CoreComponent::class.java
    )

private fun appComponent(fragment: com.newsapp.top_stories.ui.TopStoriesFragment): AppComponent =
    EntryPointAccessors.fromActivity(
        fragment.requireActivity(),
        AppComponent::class.java
    )