package com.newsapp.repository.mapper

import com.newsapp.business.model.StoryModel
import com.newsapp.repository.dto.TopStoriesDto
import javax.inject.Inject

class TopStoryRemoteMapper @Inject constructor() : Mapper<TopStoriesDto, List<StoryModel>> {
    override fun mapFromModel(dto: TopStoriesDto): List<StoryModel> {
        return dto.results.map { results ->
            StoryModel(
                subsection = results.subsection,
                title = results.title,
                abstract = results.abstract,
                url = results.url,
                image = results.multimedia.filter { it.type=="image" }.maxBy { it.height }?.url,
                date = results.published_date
            )
        }
    }
}