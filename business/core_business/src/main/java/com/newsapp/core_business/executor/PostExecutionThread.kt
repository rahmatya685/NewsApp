package com.newsapp.core_business.executor

import kotlinx.coroutines.CoroutineDispatcher

interface PostExecutionThread {
    val main: CoroutineDispatcher
    val io: CoroutineDispatcher
    val default: CoroutineDispatcher
}