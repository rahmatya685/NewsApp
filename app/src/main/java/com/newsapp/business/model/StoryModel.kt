package com.newsapp.business.model

data class StoryModel(
    val subsection: String,
    val title: String,
    val abstract: String,
    val url: String,
    val image:String?,
    val date:String
)