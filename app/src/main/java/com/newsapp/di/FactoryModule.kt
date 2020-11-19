package com.newsapp.di

import androidx.lifecycle.ViewModelProvider
import com.newsapp.di.factory.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.hilt.migration.DisableInstallInCheck

@[Module DisableInstallInCheck]
interface FactoryModule {

    @get:Binds
    val ViewModelFactory.viewModelFactory: ViewModelProvider.Factory
}