package com.leejihun.watcha.assignment.presentation.ui.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.leejihun.watcha.assignment.presentation.ui.compose.theme.WatchaassignmentTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TrackListComposeActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      WatchaassignmentTheme {
        TrackListApp()
      }
    }
  }
}
