package com.newapp.bookmark.adaptor

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.newapp.bookmark.R
import com.newapp.bookmark.databinding.ItemBookmarkedStoryBinding
import com.newsapp.business.bookmarks.actions.BookmarkedStoriesAction
import com.newsapp.business.bookmarks.model.Bookmark
import com.newsapp.views.common.ImageLoader
import com.newsapp.views.common.inflate
import kotlinx.coroutines.channels.Channel
import javax.inject.Inject

class BookmarkedStoriesAdaptor @Inject constructor(
    private val imageLoader: ImageLoader,
) : ListAdapter<Bookmark, BookmarkedStoriesAdaptor.StoryViewHolder>(
    diffUtilCallback
) {

    var clickListener: Channel<BookmarkedStoriesAction> = Channel { }

    inner class StoryViewHolder(
        private val binding: ItemBookmarkedStoryBinding,
        private val imageLoader: ImageLoader
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(model: Bookmark) = with(binding) {
            imgUser.visibility = View.INVISIBLE
            model.image?.let { img ->
                imageLoader.loadImage(imgUser, img)
                imgUser.visibility = View.VISIBLE
            }
            tvDate.text = model.date
            tvTitle.text = model.title

            imageButton.setOnClickListener {
                clickListener.offer(
                    BookmarkedStoriesAction.UnBookmarkStory(model)
                )
            }
            root.setOnClickListener {
                clickListener.offer(BookmarkedStoriesAction.ShowDetail(model))
            }

        }
    }


    companion object {
        val diffUtilCallback: DiffUtil.ItemCallback<Bookmark>
            get() = object : DiffUtil.ItemCallback<Bookmark>() {
                override fun areItemsTheSame(oldItem: Bookmark, newItem: Bookmark): Boolean {
                    return oldItem === newItem && oldItem.title == newItem.title
                }

                override fun areContentsTheSame(
                    oldItem: Bookmark,
                    newItem: Bookmark
                ): Boolean {
                    return oldItem == newItem
                }
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryViewHolder {
        return StoryViewHolder(
            ItemBookmarkedStoryBinding.bind(parent.inflate(R.layout.item_bookmarked_story)),
            imageLoader
        )
    }

    override fun onBindViewHolder(holder: StoryViewHolder, position: Int) =
        holder.bind(getItem(position))
}