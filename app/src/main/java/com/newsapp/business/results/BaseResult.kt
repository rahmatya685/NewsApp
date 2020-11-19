package com.newsapp.business.results

sealed class BaseResult<out T> : Result {
    data class Success<out T>(val data: T) : BaseResult<T>()
    data class Failure<out T>(val error: String) : BaseResult<T>()
    object Loading : BaseResult<Nothing>()
}

