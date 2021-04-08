package com.newsapp.ui


import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import com.newsapp.views.R
import com.newsapp.views.common.viewBinding
import com.newsapp.views.databinding.FragmentPagerBinding


class PagerFragment : Fragment(R.layout.fragment_pager) {


    private var binding: FragmentPagerBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPagerBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.let { binding ->
            binding.pager.adapter = StoriesPagerAdaptor(
                fragmentManager = childFragmentManager
            )
            binding.tabLayout.setupWithViewPager(binding.pager)
        }
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

}