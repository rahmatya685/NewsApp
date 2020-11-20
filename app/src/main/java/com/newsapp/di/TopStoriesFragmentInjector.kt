package com.newsapp.di

import com.newsapp.di.component.AppComponent
import com.newsapp.di.component.CoreComponent
import com.newsapp.di.component.DaggerStoriesComponent
import com.newsapp.ui.topstories.PagerFragment
import dagger.hilt.android.EntryPointAccessors

internal fun inject(fragment: PagerFragment) {
    DaggerStoriesComponent
        .factory()
        .create(coreComponent(fragment), appComponent(fragment))
        .inject(fragment)
}

private fun coreComponent(fragment: PagerFragment): CoreComponent =
    EntryPointAccessors.fromApplication(
        fragment.requireContext().applicationContext,
        CoreComponent::class.java
    )

private fun appComponent(fragment: PagerFragment): AppComponent =
    EntryPointAccessors.fromActivity(
        fragment.requireActivity(),
        AppComponent::class.java
    )