package com.newsapp.repository.mapper

import com.google.gson.Gson
import com.newsapp.DummyData
import com.newsapp.remo_impl.dto.TopStoriesDto
import junit.framework.TestCase
import org.junit.Test

class TopStoryRemoteMapperTest : TestCase() {

    @Test
    fun testMapFromModel() {
        val dto = Gson().fromJson(DummyData.topStoriesDto, com.newsapp.remo_impl.dto.TopStoriesDto::class.java)
        val model = com.newsapp.remo_impl.mapper.TopStoryRemoteMapper().mapFrom(dto)
        assertTrue(model.size == 3)
        assertTrue(model.first().title == "Trump Targets Michigan in His Ploy to Subvert the Election")
        assertTrue(model.first().url == "https://www.nytimes.com/2020/11/19/us/politics/trump-michigan-election.html")
        assertTrue(model.first().image == "https://static01.nyt.com/images/2020/11/19/us/politics/19trump-michigan/merlin_179990412_edf54e6c-a115-4773-8b3a-7c40919161ae-superJumbo.jpg")
    }
}