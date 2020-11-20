package com.newsapp.ui.topstories


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.newsapp.R
import com.newsapp.databinding.FragmentPagerBinding
import com.newsapp.ui.viewBinding 


class PagerFragment : Fragment(R.layout.fragment_pager) {


    private val binding: FragmentPagerBinding by viewBinding(FragmentPagerBinding::bind)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.let {
            binding.pager.adapter = StoriesPagerAdaptor(
                fragmentManager = it.supportFragmentManager
            )
            binding.tabLayout.setupWithViewPager(binding.pager)
        }

    }
}