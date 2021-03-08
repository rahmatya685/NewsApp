package com.newsapp.business.bookmarks.model

class Bookmark(
    val subsection: String,
    val title: String,
    val abstract: String,
    val url: String,
    val image: String?,
    val date: String
) {
    val id: Int = -1
}