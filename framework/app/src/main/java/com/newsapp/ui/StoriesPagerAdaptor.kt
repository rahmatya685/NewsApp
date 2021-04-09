package com.newsapp.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import com.newapp.bookmark.ui.BookmarkedStoriesFragment
import com.newsapp.top_stories.ui.TopStoriesFragment

class StoriesPagerAdaptor(fragmentManager: FragmentManager) :
    FragmentStatePagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val fragments = arrayListOf<Pair<String, Fragment>>()

    init {
        fragments.add("Top Stories" to TopStoriesFragment.newInstance())
        fragments.add("Bookmark" to BookmarkedStoriesFragment.newInstance())
    }

    override fun getCount(): Int = 2

    override fun getItem(position: Int): Fragment = fragments[position].second

    override fun getPageTitle(position: Int): CharSequence? = fragments[position].first

}