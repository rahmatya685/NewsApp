package com.newsapp.top_stories.ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.newsapp.business.top_stories.action.TopStoriesAction
import com.newsapp.business.top_stories.state.TopStoriesViewState
import com.newsapp.navigation.NavigationDispatcher
import com.newsapp.top_stories.R
import com.newsapp.top_stories.adaptor.StoriesAdaptor
import com.newsapp.top_stories.databinding.FragmentTopStoriesBinding
import com.newsapp.top_stories.di.injector.inject
import com.newsapp.top_stories.view_model.TopStoriesViewModel
import com.newsapp.ui_base.MviView
import com.newsapp.views.common.viewBinding
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.*
import reactivecircus.flowbinding.swiperefreshlayout.refreshes
import javax.inject.Inject
import javax.inject.Provider

@ExperimentalCoroutinesApi
class TopStoriesFragment : Fragment(), MviView<TopStoriesViewState> {

    @Inject
    lateinit var storiesAdaptor: StoriesAdaptor

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    @Inject
    lateinit var navigator: Provider<NavigationDispatcher>

    private val viewModel: TopStoriesViewModel by viewModels { factory }

    private val binding: FragmentTopStoriesBinding by viewBinding(FragmentTopStoriesBinding::bind)

    override fun onAttach(context: Context) {
        super.onAttach(context)
        inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.fragment_top_stories,
            container, false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvTopnews.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)

        val onClickListener = callbackFlow<TopStoriesAction> {
            storiesAdaptor.onClickListener = { model ->
                this.offer(TopStoriesAction.ShowDetail(model))
            }
            awaitClose()
        }

        merge(refreshAction, onClickListener)
            .onEach(viewModel::processAction)
            .launchIn(viewLifecycleOwner.lifecycleScope)

        binding.rvTopnews.adapter = storiesAdaptor
        viewModel.viewState.observe(viewLifecycleOwner, ::observeData)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            TopStoriesFragment()
    }


    override fun observeData(state: TopStoriesViewState): Unit {
        when {
            state.isLoading -> renderLoading()
            state.hasError -> {
                hideLoading()
                renderError(state)
            }
            state.hasStoryDetailToShow -> {
                showStoryDetail(state)
            }
            state.hasStories -> {
                hideLoading()
                renderNewStories(state)
            }
            state.hasBookmarkedStory -> {
                hideLoading()
                renderBookmarkedSuccessfully()
            }

        }
    }

    private fun showStoryDetail(state: TopStoriesViewState) {
        state.showStoryDetail?.let { event ->
            event.consume { story ->
                navigator.get().openStoryDetail(story.url, story.title)
                binding.rvTopnews.adapter = null
            }
        }
    }

    private fun renderBookmarkedSuccessfully() {
        showSnack("Bookmarked Successfully")
    }

    private fun renderNewStories(state: TopStoriesViewState) {
        if (state.stories.isEmpty()) {
            showSnack("No Story Found")
        } else {
            storiesAdaptor.submitList(state.stories)
        }
    }

    private fun renderError(state: TopStoriesViewState) {
        state.errorMsg?.let { msg ->
            showSnack(msg)
        }
    }

    private fun hideLoading() {
        binding.refresh.isRefreshing = false
    }

    private fun renderLoading() {
        binding.refresh.isRefreshing = true
    }

    private fun showSnack(msg: String) =
        Snackbar.make(requireView(), msg, Snackbar.LENGTH_LONG).show()


    private val refreshAction: Flow<TopStoriesAction>
        get() = binding
            .refresh.refreshes()
            .map { TopStoriesAction.LoadStories }



    override fun onDestroyView() {
        super.onDestroyView()
    }

}