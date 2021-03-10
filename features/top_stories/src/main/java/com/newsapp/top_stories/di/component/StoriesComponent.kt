package com.newsapp.top_stories.di.component

import com.newsapp.business.top_stories.di.module.TopStoriesMviModule
import com.newsapp.di.FeatureScope
import com.newsapp.di.component.AppComponent
import com.newsapp.di.component.CoreComponent
import com.newsapp.di.module.FactoryModule
import com.newsapp.top_stories.di.module.TopStoriesViewModelModule
import com.newsapp.top_stories.ui.TopStoriesFragment
import dagger.Component


@FeatureScope
@Component(
    dependencies = [CoreComponent::class, com.newsapp.di.component.AppComponent::class],
    modules = [
        FactoryModule::class,
        TopStoriesViewModelModule::class,
        TopStoriesMviModule::class
    ]
)
interface StoriesComponent {

    fun inject(frg: TopStoriesFragment)

    @Component.Factory
    interface Factory {
        fun create(
            coreComponent: CoreComponent,
            appComponent: com.newsapp.di.component.AppComponent
        ): StoriesComponent
    }
}