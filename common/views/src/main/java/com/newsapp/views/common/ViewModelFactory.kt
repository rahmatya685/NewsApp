package com.newsapp.views.common


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider


/**
 * Source
 * https://github.com/Ezike/Baking-App-Kotlin/blob/master/core/src/main/java/com/example/eziketobenna/bakingapp/core/factory/ViewModelFactory.kt
 */
@Suppress("UNCHECKED_CAST")
class ViewModelFactory @Inject constructor(
    private val creators: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val found: Map.Entry<Class<out ViewModel>, Provider<ViewModel>>? =
            creators.entries.find { modelClass.isAssignableFrom(it.key) }
        val creator: Provider<ViewModel> = found?.value
            ?: throw IllegalArgumentException("Unknown model class $modelClass")
        try {
            return creator.get() as T
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }
}
