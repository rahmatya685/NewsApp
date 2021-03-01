package com.newsapp.business.mixer

import com.newsapp.business.results.ViewResult
import com.newsapp.business.state.ViewState

interface ResultStateMixer<R : ViewResult, S : ViewState> {
    fun mix(result: R,oldState:S): S
}