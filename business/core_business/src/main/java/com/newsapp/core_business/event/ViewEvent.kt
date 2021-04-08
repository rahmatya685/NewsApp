package com.newsapp.core_business.event

data class ViewEvent<T>(val value: T) : SingleEvent<T>(value)
