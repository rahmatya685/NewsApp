package com.newsapp.repository.mapper

interface Mapper<in M,out  E> {

    fun mapFrom(model: M): E

    fun mapList(models: List<M>): List<E> {
        return models.mapTo(mutableListOf(), ::mapFrom)
    }
}