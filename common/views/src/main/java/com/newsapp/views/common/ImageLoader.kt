package com.newsapp.views.common

import android.widget.ImageView

interface ImageLoader {
    fun loadImage(view: ImageView, url: String)
}
