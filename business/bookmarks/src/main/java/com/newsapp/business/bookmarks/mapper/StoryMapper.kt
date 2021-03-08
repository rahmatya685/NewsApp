package com.newsapp.business.bookmarks.mapper

import com.newsapp.business.bookmarks.model.Bookmark
import com.newsapp.mapper.Mapper
import com.newsapp.remo_impl.data.Story
import javax.inject.Inject

class StoryMapper @Inject constructor() : Mapper<Story, Bookmark> {
    override fun mapFrom(model: Story): Bookmark =
        Bookmark(
            subsection = model.subsection,
            title = model.title,
            image = model.image,
            url = model.url,
            date = model.date,
            abstract = model.abstract
        )

}