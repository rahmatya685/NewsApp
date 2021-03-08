package com.newsapp.business.top_stories.mapper

import com.newsapp.business.top_stories.model.StoryModel
import com.newsapp.mapper.Mapper
import com.newsapp.remo_impl.data.Story
import javax.inject.Inject

class StoryMapper @Inject constructor() : Mapper<Story, StoryModel> {
    override fun mapFrom(model: Story): StoryModel {
        return StoryModel(
            subsection = model.subsection,
            title = model.title,
            abstract = model.abstract,
            url = model.url,
            image = model.image,
            date = model.date
        )
    }
}