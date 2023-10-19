package com.leejihun.watcha.assignment.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.recyclerview.widget.DividerItemDecoration
import com.leejihun.watcha.assignment.presentation.adapter.TrackAdapter
import com.leejihun.watcha.assignment.presentation.adapter.TrackLoadStateAdapter
import com.leejihun.watcha.assignment.presentation.databinding.ActivityMainBinding
import com.leejihun.watcha.assignment.presentation.extensions.repeatOnStarted
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

  private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

  private val viewModel by viewModels<MainViewModel>()

  private val trackAdapter by lazy { TrackAdapter() }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(binding.root)

    initView()
    initListener()
    initObserver()
  }

  private fun initView() {
    binding.rvMain.apply {
      addItemDecoration(DividerItemDecoration(this@MainActivity, DividerItemDecoration.VERTICAL))
      adapter = trackAdapter.withLoadStateFooter(
        footer = TrackLoadStateAdapter(
          trackAdapter::retry,
        ),
      )
    }
  }

  private fun initListener() {
    trackAdapter.addLoadStateListener { combinedLoadStates ->
      val loadState = combinedLoadStates.source
      val isListEmpty = trackAdapter.itemCount < 1 &&
        loadState.refresh is LoadState.NotLoading &&
        loadState.append.endOfPaginationReached

      binding.apply {
        tvMainNoResult.isVisible = isListEmpty
        tvMainNoResult.isVisible = isListEmpty
        pbMain.isVisible = loadState.refresh is LoadState.Loading
      }
    }
  }

  private fun initObserver() {
    repeatOnStarted {
      launch {
        viewModel.trackList.collectLatest {
          trackAdapter.submitData(it)
        }
      }
    }
  }
}
