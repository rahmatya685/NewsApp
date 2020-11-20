package com.newsapp.ui.base

import android.widget.ImageView

interface ImageLoader {
    fun loadImage(view: ImageView, url: String)
}
