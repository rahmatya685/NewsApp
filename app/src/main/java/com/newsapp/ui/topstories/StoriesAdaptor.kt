package com.newsapp.ui.topstories

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.newsapp.R
import com.newsapp.business.actions.TopStoriesAction
import com.newsapp.business.model.StoryModel
import com.newsapp.databinding.ItemStoryBinding
import com.newsapp.ui.base.ImageLoader
import com.newsapp.ui.base.inflate
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.map
import reactivecircus.flowbinding.android.view.clicks
import java.util.concurrent.Flow
import javax.inject.Inject


class StoriesAdaptor @Inject constructor(
    private val imageLoader: ImageLoader
) :
    ListAdapter<StoryModel, StoriesAdaptor.StoryViewHolder>(diffUtilCallback) {

    var clickListener: Channel<TopStoriesAction> = Channel { }

    inner class StoryViewHolder(
        private val binding: ItemStoryBinding,
        private val imageLoader: ImageLoader
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(model: StoryModel) {
            binding.imgUser.visibility = View.INVISIBLE
            model.image?.let { img ->
                imageLoader.loadImage(binding.imgUser, img)
                binding.imgUser.visibility = View.VISIBLE
            }
            binding.tvDate.text = model.date
            binding.tvTitle.text = model.title

            binding.imageButton.setOnClickListener {
                clickListener.offer(TopStoriesAction.BookmarkStory(model))
            }

        }
    }


    companion object {
        val diffUtilCallback: DiffUtil.ItemCallback<StoryModel>
            get() = object : DiffUtil.ItemCallback<StoryModel>() {
                override fun areItemsTheSame(oldItem: StoryModel, newItem: StoryModel): Boolean {
                    return oldItem === newItem && oldItem.title == newItem.title
                }

                override fun areContentsTheSame(
                    oldItem: StoryModel,
                    newItem: StoryModel
                ): Boolean {
                    return oldItem == newItem
                }
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryViewHolder {
        return StoryViewHolder(
            ItemStoryBinding.bind(parent.inflate(R.layout.item_story)),
            imageLoader
        )
    }

    override fun onBindViewHolder(holder: StoryViewHolder, position: Int) =
        holder.bind(getItem(position))
}