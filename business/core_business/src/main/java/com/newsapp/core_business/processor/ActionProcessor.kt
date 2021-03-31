package com.newsapp.core_business.processor

import com.newsapp.core_business.actions.ViewAction
import com.newsapp.core_business.result.ViewResult
import kotlinx.coroutines.flow.Flow

/*
*  calls appropriate method of UseCase and returns ViewResult
 */
interface ActionProcessor<in A : ViewAction, out R : ViewResult> {
    fun actionToResult(viewAction: A): Flow<R>
}