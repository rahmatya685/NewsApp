package com.newsapp.business.bookmarks.mapper

import com.newsapp.business.bookmarks.model.Bookmark
import com.newsapp.mapper.Mapper
import com.newsapp.remo_impl.data.Story
import javax.inject.Inject

class BookmarkMapper @Inject constructor() : Mapper<Bookmark?, Story> {
    override fun mapFrom(model: Bookmark?): Story =
        if (model == null)
            Story()
        else
            Story(
                abstract = model.abstract,
                date = model.date,
                image = model.image,
                url = model.url,
                title = model.title,
                subsection = model.subsection
            )
}