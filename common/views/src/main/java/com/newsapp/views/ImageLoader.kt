package com.newsapp.views

import android.widget.ImageView

interface ImageLoader {
    fun loadImage(view: ImageView, url: String)
}
