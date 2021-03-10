package com.newapp.bookmark.di.injector


import com.newapp.bookmark.di.component.DaggerBookmarkedStoriesComponent
import com.newapp.bookmark.ui.BookmarkedStoriesFragment
import com.newsapp.di.component.CoreComponent
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

private fun appComponent(fragment: BookmarkedStoriesFragment): com.newsapp.di.component.AppComponent =
    EntryPointAccessors.fromActivity(
        fragment.requireActivity(),
        com.newsapp.di.component.AppComponent::class.java
    )