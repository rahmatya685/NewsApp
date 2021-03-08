package com.newsapp.remo_impl.mapper

 import com.newsapp.mapper.Mapper
import com.newsapp.remo_impl.data.Story
import com.newsapp.remo_impl.local.topstories.BookmarkedEntity
import javax.inject.Inject

class BookmarkedStoryLocalMapper @Inject constructor() :
    Mapper<BookmarkedEntity, Story> {
    override fun mapFrom(entity: BookmarkedEntity): Story {
        val s= Story(
            title = entity.title,
            abstract = entity.abstract,
            date = entity.date,
            url = entity.url,
            subsection = "",
            image = entity.image,
        )
        s.id=entity.id
        return s
    }


}