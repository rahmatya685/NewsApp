package com.newsapp.repository.local.topstories

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.newsapp.repository.local.base.BaseEntity


@Entity(tableName = "BOOK_MARKED_ENTITY")
data class BookmarkedEntity(

    @ColumnInfo(name = "TITLE", typeAffinity = ColumnInfo.TEXT)
    var title: String = "",

    @ColumnInfo(name = "ABSTRACT", typeAffinity = ColumnInfo.TEXT)
    var abstract: String = "",

    @ColumnInfo(name = "URL", typeAffinity = ColumnInfo.TEXT)
    var url: String = "",

    @ColumnInfo(name = "IMAGE", typeAffinity = ColumnInfo.TEXT)
    var image: String? = null,

    @ColumnInfo(name = "DATE", typeAffinity = ColumnInfo.TEXT)
    var date: String = ""

) : BaseEntity() {
}