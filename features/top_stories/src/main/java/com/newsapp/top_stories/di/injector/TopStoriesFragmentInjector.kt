package com.newsapp.top_stories.di.injector

import com.newsapp.di.component.AppComponent
import com.newsapp.di.component.CoreComponent
import com.newsapp.top_stories.di.component.DaggerStoriesComponent
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

private fun appComponent(fragment: TopStoriesFragment): com.newsapp.di.component.AppComponent =
    EntryPointAccessors.fromActivity(
        fragment.requireActivity(),
        com.newsapp.di.component.AppComponent::class.java
    )