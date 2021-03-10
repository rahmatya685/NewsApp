package com.newsapp.story_details.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.newsapp.business.top_stories.model.StoryModel
import com.newsapp.story_details.R
import com.newsapp.story_details.databinding.FragmentStoryDetailBinding
import com.newsapp.views.common.ImageLoaderImpl
import com.newsapp.views.common.viewBinding


class StoryDetailFragment : BottomSheetDialogFragment() {


    private val args: StoryDetailFragmentArg by navArgs()

    private val binding: FragmentStoryDetailBinding by viewBinding(FragmentStoryDetailBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_story_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindInfo(args.storyModel)

    }

    private fun bindInfo(storyModel: StoryModel) {
        storyModel.image?.let { url ->
            ImageLoaderImpl().loadImage(binding.imgUser, url)
        }
        binding.tvAbstract.text = storyModel.abstract
        binding.tvDate.text = storyModel.date
        binding.tvTitle.text = storyModel.title
        binding.btnContinueReading.setOnClickListener {
            openUrl(storyModel.url)
        }
    }

    private fun openUrl(url: String) {
        val i = Intent(Intent.ACTION_VIEW)
        i.data = Uri.parse(url)
        startActivity(i)
    }

    companion object {
        @JvmStatic
        fun newInstance() = StoryDetailFragment()
    }
}