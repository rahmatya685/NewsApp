package com.newsapp.ui.base

import com.newsapp.business.state.ViewState

interface MviView<T:ViewState> {
    fun observeData(state:T):Unit
}