package com.newsapp.di.module

import androidx.lifecycle.ViewModel
import com.newsapp.di.ViewModelKey
import com.newsapp.top_stories.view_model.TopStoriesViewModel
import dagger.Binds
import dagger.Module
import dagger.hilt.migration.DisableInstallInCheck
import dagger.multibindings.IntoMap


@DisableInstallInCheck
@Module
interface TopStoriesViewModelModule {

    @get:[Binds IntoMap ViewModelKey(com.newsapp.top_stories.view_model.TopStoriesViewModel::class)]
    val com.newsapp.top_stories.view_model.TopStoriesViewModel.topStoriesViewModel: ViewModel
}