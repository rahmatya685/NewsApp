package com.newsapp.repository.local.base

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

open class BaseEntity {
    @ColumnInfo(name = "ID")
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}