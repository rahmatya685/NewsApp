package com.newsapp.repository.mapper

import com.newsapp.business.model.StoryModel
import com.newsapp.repository.dto.TopStoriesDto
import javax.inject.Inject

class TopStoryRemoteMapper @Inject constructor() : Mapper<TopStoriesDto, List<StoryModel>> {
    override fun mapFrom(dto: TopStoriesDto): List<StoryModel> {
        return dto.results.map { results ->
            StoryModel(
                subsection = results.subsection,
                title = results.title,
                abstract = results.abstract,
                url = results.url,
                image = if (results.multimedia != null) results.multimedia.filter { it.type == "image" }
                    .maxBy { it.height }?.url else null,
                date = results.published_date
            )
        }
    }


}