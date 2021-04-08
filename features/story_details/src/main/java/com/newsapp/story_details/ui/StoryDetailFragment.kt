package com.newsapp.story_details.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.newsapp.business.top_stories.model.StoryModel
import com.newsapp.story_details.R
import com.newsapp.story_details.databinding.FragmentStoryDetailBinding
import com.newsapp.views.common.ImageLoaderImpl
import com.newsapp.views.common.viewBinding


class StoryDetailFragment : Fragment(R.layout.fragment_story_detail) {


    private val args: StoryDetailFragmentArgs by navArgs()

    private val binding: FragmentStoryDetailBinding by viewBinding(FragmentStoryDetailBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.webivew.loadUrl(
            args.pUrl
                .replace("{", "")
                .replace("}", "")
        )
    }

}