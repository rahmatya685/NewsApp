package com.newapp.bookmark.di.component


import com.newapp.bookmark.di.module.BookmarkedStoriesViewModelModule
import com.newapp.bookmark.ui.BookmarkedStoriesFragment
import com.newsapp.business.bookmarks.di.module.BookmarkedStoriesMviModule
import com.newsapp.di.FeatureScope
import com.newsapp.di.component.AppComponent
import com.newsapp.di.component.CoreComponent
import com.newsapp.views.di.module.FactoryModule
import dagger.Component


@FeatureScope
@Component(
    dependencies = [CoreComponent::class, AppComponent::class],
    modules = [
        FactoryModule::class,
        BookmarkedStoriesViewModelModule::class,
        BookmarkedStoriesMviModule::class]
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