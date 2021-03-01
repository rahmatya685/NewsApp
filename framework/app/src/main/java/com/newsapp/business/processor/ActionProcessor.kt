package com.newsapp.business.processor

import com.newsapp.business.actions.ViewAction
import com.newsapp.business.results.ViewResult
import kotlinx.coroutines.flow.Flow

/*
*  calls appropriate method of UseCase and returns ViewResult
 */
interface ActionProcessor<in A : ViewAction, out R : ViewResult> {
    fun actionToResult(viewAction: A): Flow<R>
}