package com.newsapp.ui


import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.navigation.navGraphViewModels
import com.newsapp.top_stories.databinding.FragmentTopStoriesBinding
import com.newsapp.views.R
import com.newsapp.views.common.viewBinding
import com.newsapp.views.databinding.FragmentPagerBinding


class PagerFragment : Fragment(R.layout.fragment_pager) {

    private val binding: FragmentPagerBinding by viewBinding(FragmentPagerBinding::bind)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
             R.layout.fragment_pager,
            container, false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.pager.adapter = StoriesPagerAdaptor(
            fragmentManager = childFragmentManager
        )
        binding.tabLayout.setupWithViewPager(binding.pager)
    }


}