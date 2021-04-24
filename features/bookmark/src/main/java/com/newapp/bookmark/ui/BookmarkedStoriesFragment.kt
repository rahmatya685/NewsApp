package com.newapp.bookmark.ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.newapp.bookmark.R
import com.newapp.bookmark.adaptor.BookmarkedStoriesAdaptor
import com.newapp.bookmark.databinding.FragmentBookmarkedStoriesBinding
import com.newapp.bookmark.di.injector.inject
import com.newsapp.business.bookmarks.state.BookmarkedStoriesViewState
import com.newapp.bookmark.viewmodel.BookmarkedStoriesViewModel
import com.newsapp.business.bookmarks.actions.BookmarkedStoriesAction
import com.newsapp.navigation.NavigationDispatcher
import com.newsapp.ui_base.MviView
import com.newsapp.views.common.viewBinding
import kotlinx.coroutines.flow.*
import reactivecircus.flowbinding.swiperefreshlayout.refreshes
import javax.inject.Inject
import javax.inject.Provider


class BookmarkedStoriesFragment : Fragment(),
        MviView<BookmarkedStoriesViewState> {

    @Inject
    lateinit var storiesAdaptor: BookmarkedStoriesAdaptor

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

        binding.apply {
            rvBookmarkedStories.adapter = storiesAdaptor
            rvBookmarkedStories.layoutManager = GridLayoutManager(activity, 2)
            viewModel.viewState.observe(viewLifecycleOwner, ::observeData)

            refresh.refreshes()
                    .map { BookmarkedStoriesAction.LoadStories }
                    .onEach(viewModel::processAction)
                    .launchIn(viewLifecycleOwner.lifecycleScope)
        }

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
            state.showSuccess -> renderSuccess(state)
            else -> hideLoading()
        }
    }

    private fun renderNewStories(state: BookmarkedStoriesViewState) {
        binding.tvInfo.visibility = View.GONE
        storiesAdaptor.submitList(state.stories)
    }

    private fun renderError(state: BookmarkedStoriesViewState) {
        state.errorMsg?.let { msg ->
            showSnack(msg)
        }
    }

    private fun showStoryDetail(state: BookmarkedStoriesViewState) {
        state.currentBookmark?.let { b ->
            navigator.get().openBookmarkDetail(b.id)
        }

    }

    private fun renderSuccess(state: BookmarkedStoriesViewState) {
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

    override fun onStop() {
        super.onStop()
        binding.rvBookmarkedStories.adapter = null
    }

    companion object {
        @JvmStatic
        fun newInstance() =
                BookmarkedStoriesFragment()
    }

}


