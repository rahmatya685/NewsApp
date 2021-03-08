package com.newsapp.di

import com.newsapp.di.component.AppComponent
import com.newsapp.di.component.CoreComponent
import com.newsapp.di.component.DaggerBookmarkedStoriesComponent
import com.newapp.bookmark.BookmarkedStoriesFragment
import dagger.hilt.android.EntryPointAccessors

internal fun inject(fragment: BookmarkedStoriesFragment) {
    DaggerBookmarkedStoriesComponent
        .factory()
        .create(coreComponent(fragment), appComponent(fragment))
        .inject(fragment)
}

private fun coreComponent(fragment: BookmarkedStoriesFragment): CoreComponent =
    EntryPointAccessors.fromApplication(
        fragment.requireContext().applicationContext,
        CoreComponent::class.java
    )

private fun appComponent(fragment: BookmarkedStoriesFragment): AppComponent =
    EntryPointAccessors.fromActivity(
        fragment.requireActivity(),
        AppComponent::class.java
    )