package com.leejihun.watcha.assignment.presentation.ui.compose

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.leejihun.watcha.assignment.presentation.TrackListViewModel
import com.leejihun.watcha.assignment.presentation.ui.compose.screens.TrackListScreen

@Composable
fun TrackListApp(
  viewModel: TrackListViewModel = hiltViewModel(),
) {
  val trackItems = viewModel.trackList.collectAsLazyPagingItems()

  Surface(
    modifier = Modifier.fillMaxSize(),
    color = Color.White,
  ) {
    TrackListScreen(trackItems = trackItems)
  }
}
