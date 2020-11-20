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
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.newsapp.R
import com.newsapp.business.actions.BookmarkedStoriesAction
import com.newsapp.business.state.BookmarkedStoriesViewState
import com.newsapp.databinding.FragmentBookmarkedStoriesBinding
import com.newsapp.di.inject
import com.newsapp.navigation.NavigationDispatcher
import com.newsapp.ui.base.MviView
import com.newsapp.ui.viewBinding
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.merge
import reactivecircus.flowbinding.swiperefreshlayout.refreshes
import javax.inject.Inject
import javax.inject.Provider


class BookmarkedStoriesFragment : Fragment(), MviView<BookmarkedStoriesViewState> {

    @Inject
    lateinit var storiesAdaptor: StoriesAdaptor

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    @Inject
    lateinit var navigator: Provider<NavigationDispatcher>

    private val viewModel: BookmarkedStoriesViewModel by viewModels { factory }

    private val binding: FragmentBookmarkedStoriesBinding by viewBinding(
        FragmentBookmarkedStoriesBinding::bind
    )

    override fun onAttach(context: Context) {
        super.onAttach(context)
        inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvBookmarkedStories.adapter = storiesAdaptor
        binding.rvBookmarkedStories.layoutManager  = GridLayoutManager(activity,2)
        viewModel.viewState.observe(viewLifecycleOwner,::observeData)
        viewModel.processAction(intents)
    }

    override fun observeData(state: BookmarkedStoriesViewState): Unit {
        when {
            state.isLoading -> renderLoading()
            state.hasError -> {
                hideLoading()
                renderError(state)
            }
            state.hasStories -> {
                hideLoading()
                renderNewStories(state)
            }
            else -> hideLoading()
        }
    }

    private fun renderNewStories(state: BookmarkedStoriesViewState) {
        if (state.stories.isEmpty()) {
            showSnack("No Story Found")
        } else {
            storiesAdaptor.submitList(state.stories)
        }
    }

    private fun renderError(state: BookmarkedStoriesViewState) {
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
        Snackbar.make(binding.root, msg, Snackbar.LENGTH_LONG).show()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.fragment_bookmarked_stories,
            container, false
        )
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            BookmarkedStoriesFragment()
    }

    private val refreshAction: Flow<BookmarkedStoriesAction>
        get() = binding.refresh.refreshes().map { BookmarkedStoriesAction.LoadStories }

    private val intents: Flow<BookmarkedStoriesAction>
        get() = merge(refreshAction)
}


