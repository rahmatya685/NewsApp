package com.newsapp.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.newsapp.views.R
import com.newsapp.views.common.viewBinding
import com.newsapp.views.databinding.FragmentPagerBinding


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