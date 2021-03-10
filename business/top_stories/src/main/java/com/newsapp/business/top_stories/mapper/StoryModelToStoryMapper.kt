package com.newsapp.business.top_stories.mapper

import com.newsapp.business.top_stories.model.StoryModel
import com.newsapp.mapper.Mapper
import com.newsapp.remo_impl.data.Story
import javax.inject.Inject

class StoryModelToStoryMapper @Inject constructor(): Mapper<StoryModel, Story> {
    override fun mapFrom(model: StoryModel): Story = Story(
        title = model.title,
        abstract = model.abstract,
        date = model.date,
        url = model.url,
        image = model.image,
        subsection = model.subsection
    )
}