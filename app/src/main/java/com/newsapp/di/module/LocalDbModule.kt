package com.newsapp.di.module

import android.content.Context
import androidx.room.Room
import com.newsapp.di.FeatureScope
import com.newsapp.repository.local.base.DB_NAME
import com.newsapp.repository.local.base.LocalDb
import com.newsapp.repository.local.topstories.BookmarkedEntityDao
import com.newsapp.repository.local.topstories.BookmarkedStoriesRepo
import com.newsapp.repository.local.topstories.BookmarkedStoriesRepoImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton


@Module
@InstallIn(ApplicationComponent::class)
interface LocalDbModule {

    @get:[Binds Singleton]
    val BookmarkedStoriesRepoImpl.bookmarkedRepo:BookmarkedStoriesRepo

    companion object {

        @Provides
        @Singleton
        fun provideAppDatabase(@ApplicationContext appContext: Context): LocalDb {
            return Room.databaseBuilder(
                appContext,
                LocalDb::class.java,
                DB_NAME
            ).build()
        }

        @Provides
        fun provideBookmarkedStoriesDao(db: LocalDb): BookmarkedEntityDao {
            return db.bookmarkedEntityDao()
        }

    }

}