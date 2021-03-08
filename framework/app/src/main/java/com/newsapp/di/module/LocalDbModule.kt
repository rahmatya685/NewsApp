package com.newsapp.di.module

import android.content.Context
import androidx.room.Room
import com.newsapp.remo_impl.local.base.DB_NAME
import com.newsapp.remo_impl.local.base.LocalDb
import com.newsapp.remo_impl.local.topstories.BookmarkedEntityDao
import com.newsapp.remo_impl.local.topstories.BookmarkedStoriesRepo
import com.newsapp.remo_impl.local.topstories.BookmarkedStoriesRepoImpl
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
    val com.newsapp.remo_impl.local.topstories.BookmarkedStoriesRepoImpl.bookmarkedRepo: com.newsapp.remo_impl.local.topstories.BookmarkedStoriesRepo

    companion object {

        @Provides
        @Singleton
        fun provideAppDatabase(@ApplicationContext appContext: Context): com.newsapp.remo_impl.local.base.LocalDb {
            return Room.databaseBuilder(
                appContext,
                com.newsapp.remo_impl.local.base.LocalDb::class.java,
                com.newsapp.remo_impl.local.base.DB_NAME
            ).build()
        }

        @Provides
        fun provideBookmarkedStoriesDao(db: com.newsapp.remo_impl.local.base.LocalDb): com.newsapp.remo_impl.local.topstories.BookmarkedEntityDao {
            return db.bookmarkedEntityDao()
        }

    }

}