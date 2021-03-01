package com.newsapp.di.component

import com.newsapp.di.FactoryModule
import com.newsapp.di.FeatureScope
import com.newsapp.di.module.BookmarkedStoriesMviModule
import com.newsapp.di.module.BookmarkedStoriesViewModelModule
import com.newsapp.ui.bookmarks.BookmarkedStoriesFragment
import dagger.Component


@FeatureScope
@Component(
    dependencies = [CoreComponent::class, AppComponent::class],
    modules = [FactoryModule::class, BookmarkedStoriesViewModelModule::class, BookmarkedStoriesMviModule::class]
)
interface BookmarkedStoriesComponent {

    fun inject(frg: BookmarkedStoriesFragment)

    @Component.Factory
    interface Factory {
        fun create(
            coreComponent: CoreComponent,
            appComponent: AppComponent
        ): BookmarkedStoriesComponent
    }
}