package com.newsapp.remo_impl.data

class Story(
    val subsection: String = "",
    val title: String = "",
    val abstract: String = "",
    val url: String = "",
    val image: String? = null,
    val date: String = ""
) {
    var id: Int = -1;
}