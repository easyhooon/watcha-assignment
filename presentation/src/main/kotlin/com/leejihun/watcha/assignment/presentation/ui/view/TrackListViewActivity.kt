package com.leejihun.watcha.assignment.presentation.ui.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.paging.LoadState
import com.leejihun.watcha.assignment.presentation.R
import com.leejihun.watcha.assignment.presentation.TrackListViewModel
import com.leejihun.watcha.assignment.presentation.ui.view.adapter.TrackAdapter
import com.leejihun.watcha.assignment.presentation.ui.view.adapter.TrackLoadStateAdapter
import com.leejihun.watcha.assignment.presentation.databinding.ActivityTrackListBinding
import com.leejihun.watcha.assignment.presentation.extensions.addDivider
import com.leejihun.watcha.assignment.presentation.extensions.repeatOnStarted
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChangedBy
import kotlinx.coroutines.launch

@AndroidEntryPoint
class TrackListViewActivity : AppCompatActivity() {

  private val binding by lazy { ActivityTrackListBinding.inflate(layoutInflater) }

  private val viewModel by viewModels<TrackListViewModel>()

  private val trackAdapter by lazy {
    TrackAdapter { uri ->
      val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(uri))
      startActivity(browserIntent)
    }
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(binding.root)

    initView()
    initListener()
    initObserver()
  }

  private fun initView() {
    binding.rvTrackList.apply {
      setHasFixedSize(true)
      adapter = trackAdapter.withLoadStateFooter(
        footer = TrackLoadStateAdapter(
          trackAdapter::retry,
        ),
      )
      addDivider(R.color.gray_300)
    }
  }

  private fun initListener() {
    binding.btnTrackListRetry.setOnClickListener {
      viewModel.refresh()
    }
  }

  private fun initObserver() {
    repeatOnStarted {
      launch {
        viewModel.trackList.collectLatest {
          trackAdapter.submitData(it)
        }
      }

      launch {
        trackAdapter.loadStateFlow
          .distinctUntilChangedBy { it.refresh }
          .collect { loadStates ->
            val loadState = loadStates.source

            val isListEmpty = trackAdapter.itemCount < 1 &&
              loadState.refresh is LoadState.NotLoading &&
              loadState.append.endOfPaginationReached

            val isError = loadState.refresh is LoadState.Error

            binding.apply {
              pbTrackList.isVisible = loadState.refresh is LoadState.Loading
              tvTrackListNoResult.isVisible = isListEmpty
              rvTrackList.isVisible = !isListEmpty

              tvTrackListError.isVisible = isError
              btnTrackListRetry.isVisible = isError
            }
          }
      }

      launch {
        viewModel.refreshClickEvent.collect {
          trackAdapter.retry()
        }
      }
    }
  }
}
