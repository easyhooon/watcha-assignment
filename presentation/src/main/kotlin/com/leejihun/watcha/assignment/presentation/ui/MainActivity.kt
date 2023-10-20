package com.leejihun.watcha.assignment.presentation.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.leejihun.watcha.assignment.presentation.databinding.ActivityMainBinding
import com.leejihun.watcha.assignment.presentation.extensions.startActivityWithAnimation
import com.leejihun.watcha.assignment.presentation.ui.compose.TrackListComposeActivity
import com.leejihun.watcha.assignment.presentation.ui.view.TrackListViewActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

  private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(binding.root)

    initListener()
  }

  private fun initListener() {
    binding.btnSearchView.setOnClickListener {
      startActivityWithAnimation<TrackListViewActivity>(
        withFinish = false,
      )
    }
    binding.btnSearchCompose.setOnClickListener {
      startActivityWithAnimation<TrackListComposeActivity>(
        withFinish = false,
      )
    }
  }
}
