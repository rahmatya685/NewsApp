package com.newsapp.ui.topstories

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.newsapp.R
import com.newsapp.databinding.FragmentTopStoriesBinding
import com.newsapp.di.inject
import com.newsapp.navigation.NavigationDispatcher
import com.newsapp.ui.viewBinding
import javax.inject.Inject
import javax.inject.Provider


class TopStoriesFragment : Fragment(R.layout.fragment_top_stories) {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    @Inject
    lateinit var navigator: Provider<NavigationDispatcher>

    private val viewModel: TopStoriesViewModel by viewModels { factory }

    private val binding: FragmentTopStoriesBinding by viewBinding (FragmentTopStoriesBinding::bind)


    override fun onAttach(context: Context) {
        super.onAttach(context)
        inject(this)
    }

}