package com.newsapp.ui.topstories

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import com.newsapp.R
import com.newsapp.business.state.TopStoriesViewState
import com.newsapp.databinding.FragmentTopStoriesBinding
import com.newsapp.di.inject
import com.newsapp.navigation.NavigationDispatcher
import com.newsapp.ui.base.MviView
import com.newsapp.ui.viewBinding
import javax.inject.Inject
import javax.inject.Provider


class TopStoriesFragment : Fragment(R.layout.fragment_top_stories),MviView<TopStoriesViewState> {

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.viewState.observe(viewLifecycleOwner,::observe)
    }

    override fun observe(state: TopStoriesViewState) {
        when {
            state.isLoading -> renderLoading(state)
            state.hasError -> renderError(state)
            state.hasStories -> renderNewStories(state)
        }
    }

    private fun renderNewStories(state: TopStoriesViewState) {

    }

    private fun renderError(state: TopStoriesViewState) {


    }

    private fun renderLoading(state: TopStoriesViewState) {

    }


}