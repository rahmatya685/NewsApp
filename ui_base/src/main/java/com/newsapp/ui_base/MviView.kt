package com.newsapp.ui_base

import com.newsapp.core_business.state.ViewState


interface MviView<T: ViewState> {
    fun observeData(state:T):Unit
}