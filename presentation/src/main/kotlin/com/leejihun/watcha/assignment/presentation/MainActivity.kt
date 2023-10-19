package com.leejihun.watcha.assignment.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.paging.map
import com.leejihun.watcha.assignment.presentation.databinding.ActivityMainBinding
import com.leejihun.watcha.assignment.presentation.extensions.repeatOnStarted
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

  private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

  private val viewModel by viewModels<MainViewModel>()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(binding.root)

    repeatOnStarted {
      launch {
        viewModel.trackList.collectLatest { trackList ->
          trackList.map { track ->
            Timber.d("$track")
          }
        }
      }
    }

  }
}
