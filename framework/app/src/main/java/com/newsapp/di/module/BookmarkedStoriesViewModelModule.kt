package com.newsapp.di.module

import androidx.lifecycle.ViewModel
import com.newsapp.di.ViewModelKey
import com.newapp.bookmark.BookmarkedStoriesViewModel
import dagger.Binds
import dagger.Module
import dagger.hilt.migration.DisableInstallInCheck
import dagger.multibindings.IntoMap


@DisableInstallInCheck
@Module
interface BookmarkedStoriesViewModelModule {

    @get:[Binds IntoMap ViewModelKey(BookmarkedStoriesViewModel::class)]
    val BookmarkedStoriesViewModel.bookmarkedViewModel: ViewModel
}