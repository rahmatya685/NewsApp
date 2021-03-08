package com.newsapp.ui.storydetail

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavArgs
import com.newsapp.business.top_stories.model.StoryModel
import com.newsapp.navigation.NavigationDispatcherImpl
import java.io.Serializable

data class StoryDetailFragmentArg(
    val storyModel: StoryModel
) : NavArgs {
    @Suppress("CAST_NEVER_SUCCEEDS")
    fun toBundle(): Bundle {
        val result = Bundle()
        if (Parcelable::class.java.isAssignableFrom(StoryModel::class.java)) {
            result.putParcelable("storyModel", this.storyModel as Parcelable)
        } else if (Serializable::class.java.isAssignableFrom(StoryModel::class.java)) {
            result.putSerializable("storyModel", this.storyModel as Serializable)
        } else {
            throw UnsupportedOperationException(
                StoryModel::class.java.name +
                        " must implement Parcelable or Serializable or must be an Enum."
            )
        }
        return result
    }

    companion object {
        @JvmStatic
        fun fromBundle(bundle: Bundle): StoryDetailFragmentArg {
            bundle.setClassLoader(StoryModel::class.java.classLoader)
            val __storyModel: StoryModel?
            if (bundle.containsKey(NavigationDispatcherImpl.STORY_KEY)) {
                if (Parcelable::class.java.isAssignableFrom(StoryModel::class.java) ||
                    Serializable::class.java.isAssignableFrom(StoryModel::class.java)
                ) {
                    __storyModel =
                        bundle.get(NavigationDispatcherImpl.STORY_KEY) as StoryModel?
                } else {
                    throw UnsupportedOperationException(
                        StoryModel::class.java.name +
                                " must implement Parcelable or Serializable or must be an Enum."
                    )
                }
                if (__storyModel == null) {
                    throw IllegalArgumentException("Argument \"StoryModel\" is marked as non-null but was passed a null value.")
                }
            } else {
                throw IllegalArgumentException("Required argument \"StoryModel\" is missing and does not have an android:defaultValue")
            }
            return StoryDetailFragmentArg(__storyModel)
        }
    }
}
