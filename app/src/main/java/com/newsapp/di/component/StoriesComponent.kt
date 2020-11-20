package com.newsapp.di.component

import com.newsapp.di.FactoryModule
import com.newsapp.di.FeatureScope
import com.newsapp.di.module.MviModule
import com.newsapp.di.module.TopStoriesViewModelModule
import com.newsapp.ui.topstories.TopStoriesFragment
import dagger.Component


@FeatureScope
@Component(
    dependencies = [CoreComponent::class, AppComponent::class],
    modules = [FactoryModule::class, TopStoriesViewModelModule::class, MviModule::class]
)
interface StoriesComponent {

    fun inject(frg: TopStoriesFragment)

    @Component.Factory
    interface Factory {
        fun create(
            coreComponent: CoreComponent,
            appComponent: AppComponent
        ): StoriesComponent
    }
}