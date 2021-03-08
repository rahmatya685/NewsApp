package com.newsapp.remo_impl.mapper

import com.newsapp.mapper.Mapper
import com.newsapp.remo_impl.data.Story
import com.newsapp.remo_impl.local.topstories.BookmarkedEntity
import javax.inject.Inject

class BookmarkedEntityMapper @Inject constructor() :
    Mapper<Story, BookmarkedEntity> {
    override fun mapFrom(entity: Story): BookmarkedEntity {
        return BookmarkedEntity(
            title = entity.title,
            image = entity.image,
            url = entity.url,
            date = entity.date,
            abstract = entity.abstract
        )
    }
}