package com.newsapp.repository.mapper

interface Mapper<in M, out E> {

    fun mapFromModel(model: M): E

    fun mapModelList(models: List<M>): List<E> {
        return models.mapTo(mutableListOf(), ::mapFromModel)
    }
}