package com.newsapp.repository.mapper

import com.newsapp.business.model.StoryModel
import com.newsapp.repository.local.topstories.BookmarkedEntity
import javax.inject.Inject

class BookmarkedStoryLocalMapper @Inject constructor() :
    Mapper<BookmarkedEntity, StoryModel> {
    override fun mapFrom(entity: BookmarkedEntity): StoryModel {
        return StoryModel(
            title = entity.title,
            abstract = entity.abstract,
            date = entity.date,
            url = entity.url,
            subsection = "",
            image = entity.image
        )
    }


}