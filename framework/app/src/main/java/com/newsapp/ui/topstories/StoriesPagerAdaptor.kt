package com.newsapp.ui.topstories

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.newsapp.ui.bookmarks.BookmarkedStoriesFragment

class StoriesPagerAdaptor(fragmentManager: FragmentManager) :
    FragmentPagerAdapter(fragmentManager) {

    private val fragments = arrayListOf<Pair<String, Fragment>>()

    init {
        fragments.add("Top Stories" to TopStoriesFragment.newInstance())
        fragments.add("Bookmark" to BookmarkedStoriesFragment.newInstance())
     }

    override fun getCount(): Int = fragments.size

    override fun getItem(position: Int): Fragment = fragments[position].second

    override fun getPageTitle(position: Int): CharSequence?  = fragments[position].first

}