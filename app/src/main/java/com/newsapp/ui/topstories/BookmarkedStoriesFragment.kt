package com.newsapp.ui.topstories

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.newsapp.R


class BookmarkedStoriesFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.fragment_bookmarked_stories,
            container, false
        )
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            BookmarkedStoriesFragment()
    }
}