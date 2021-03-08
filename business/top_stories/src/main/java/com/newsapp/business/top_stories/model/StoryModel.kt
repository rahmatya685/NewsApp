package com.newsapp.business.top_stories.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class StoryModel(
    val subsection: String,
    val title: String,
    val abstract: String,
    val url: String,
    val image: String?,
    val date: String
) : Parcelable