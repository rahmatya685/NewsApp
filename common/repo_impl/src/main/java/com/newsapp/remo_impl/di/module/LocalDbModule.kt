package com.newsapp.remo_impl.di.module

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
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
interface LocalDbModule {

  @get:[Binds Singleton]
  val BookmarkedStoriesRepoImpl.bookmarkedRepo: BookmarkedStoriesRepo

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
