package com.leejihun.watcha.assignment.presentation.ui.compose.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.itemContentType
import androidx.paging.compose.itemKey
import com.leejihun.watcha.assignment.domain.entity.TrackEntity
import com.leejihun.watcha.assignment.presentation.R
import com.leejihun.watcha.assignment.presentation.ui.compose.TrackCard

@Composable
fun TrackListScreen(
  trackItems: LazyPagingItems<TrackEntity>,
) {
  val listState = rememberLazyListState()

  val isLoading = trackItems.loadState.refresh is LoadState.Loading
  val isError = trackItems.loadState.refresh is LoadState.Error

  when {
    isLoading -> {
      LoadingScreen()
    }

    isError -> {
      ErrorScreen(
        errorMessage = stringResource(id = R.string.error_message),
        onClickRetryButton = { trackItems.retry() },
      )
    }

    else -> {
      LazyColumn(state = listState) {
        items(
          count = trackItems.itemCount,
          key = trackItems.itemKey(key = { track -> track.trackId }),
          contentType = trackItems.itemContentType(),
        ) { index ->
          trackItems[index]?.let { track ->
            TrackCard(
              track = track,
              onClick = {},
            )
          }
        }
      }
    }
  }
}
