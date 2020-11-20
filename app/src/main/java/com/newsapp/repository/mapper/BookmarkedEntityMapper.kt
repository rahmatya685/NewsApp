package com.newsapp.repository.mapper

import com.newsapp.business.model.StoryModel
import com.newsapp.repository.local.topstories.BookmarkedEntity
import javax.inject.Inject

class BookmarkedEntityMapper @Inject constructor(): Mapper<StoryModel, BookmarkedEntity> {
    override fun mapFrom(entity: StoryModel): BookmarkedEntity {
        return BookmarkedEntity(
            title = entity.title,
            image = entity.image,
            url = entity.url,
            date = entity.date,
            abstract = entity.abstract
        )
    }
}