package com.newsapp.di.module


import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.newsapp.R
import com.newsapp.navigation.NavigationDispatcher
import com.newsapp.navigation.NavigationDispatcherImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@InstallIn(ActivityComponent::class)
@Module
interface NavigationModule {

    @get:Binds
    val NavigationDispatcherImpl.navigationDispatcher: NavigationDispatcher

    companion object {
        @Provides
        fun provideNavController(activity: Activity): NavController {
            val frg =
                (activity as AppCompatActivity)
                    .supportFragmentManager
                    .findFragmentById(R.id.mainNavHostFragment)
            return frg!!.findNavController()
        }

    }
}