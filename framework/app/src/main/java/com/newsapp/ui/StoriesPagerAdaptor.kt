package com.newsapp.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import com.newapp.bookmark.ui.BookmarkedStoriesFragment
import com.newsapp.top_stories.ui.TopStoriesFragment
import kotlinx.coroutines.ExperimentalCoroutinesApi

const val TOP_STORIES_FRG="Top Stories"
const val BOOKMARK_FRG ="Bookmark"

class StoriesPagerAdaptor(fragmentManager: FragmentManager) :
    FragmentStatePagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val fragments = arrayOf(TOP_STORIES_FRG , BOOKMARK_FRG)

    override fun getCount(): Int = fragments.size

    @ExperimentalCoroutinesApi
    override fun getItem(position: Int): Fragment =
        when(fragments[position]){
            TOP_STORIES_FRG -> TopStoriesFragment.newInstance()
            BOOKMARK_FRG -> BookmarkedStoriesFragment.newInstance()
            else -> TopStoriesFragment.newInstance()
        }


    override fun getPageTitle(position: Int): CharSequence? = fragments[position]

}