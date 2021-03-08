package com.newsapp.core_business.mixer

import com.newsapp.core_business.result.ViewResult
import com.newsapp.core_business.state.ViewState

interface ResultStateMixer<R :  ViewResult, S :  ViewState> {
    fun mix(result: R,oldState:S): S
}