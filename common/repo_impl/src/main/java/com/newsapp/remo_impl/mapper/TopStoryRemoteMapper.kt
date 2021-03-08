package com.newsapp.remo_impl.mapper

import com.newsapp.mapper.Mapper
import com.newsapp.remo_impl.data.Story
import com.newsapp.remo_impl.dto.TopStoriesDto
import javax.inject.Inject

class TopStoryRemoteMapper @Inject constructor() : Mapper<TopStoriesDto, List<Story>> {
    override fun mapFrom(dto: TopStoriesDto): List<Story> {
        return dto.results.map { results ->
            Story(
                subsection = results.subsection,
                title = results.title,
                abstract = results.abstract,
                url = results.url,
                image = if (results.multimedia != null)
                    results.multimedia
                        .filter { it.type == "image" }
                        .maxBy { it.height }?.url else null,
                date = results.published_date
            )
        }
    }


}