package com.newsapp.di

import com.newsapp.di.component.AppComponent
import com.newsapp.di.component.CoreComponent
import com.newsapp.di.component.DaggerStoriesComponent
import com.newsapp.top_stories.ui.TopStoriesFragment
import dagger.hilt.android.EntryPointAccessors

internal fun inject(fragment: TopStoriesFragment) {
    DaggerStoriesComponent
        .factory()
        .create(coreComponent(fragment), appComponent(fragment))
        .inject(fragment)
}

private fun coreComponent(fragment: TopStoriesFragment): CoreComponent =
    EntryPointAccessors.fromApplication(
        fragment.requireContext().applicationContext,
        CoreComponent::class.java
    )

private fun appComponent(fragment: TopStoriesFragment): AppComponent =
    EntryPointAccessors.fromActivity(
        fragment.requireActivity(),
        AppComponent::class.java
    )