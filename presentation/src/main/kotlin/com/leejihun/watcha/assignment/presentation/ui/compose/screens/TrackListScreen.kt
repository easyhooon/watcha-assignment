package com.leejihun.watcha.assignment.presentation.ui.compose.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.itemContentType
import androidx.paging.compose.itemKey
import com.leejihun.watcha.assignment.domain.entity.TrackEntity
import com.leejihun.watcha.assignment.presentation.ui.compose.components.LoadStateFooter
import com.leejihun.watcha.assignment.presentation.ui.compose.components.TrackCard
import com.leejihun.watcha.assignment.presentation.ui.compose.theme.Gray300

@Composable
fun TrackListScreen(
  modifier: Modifier = Modifier,
  trackItems: LazyPagingItems<TrackEntity>,
) {
  val context = LocalContext.current

  val isLoading = trackItems.loadState.refresh is LoadState.Loading
  val isError = trackItems.loadState.refresh is LoadState.Error

  when {
    isLoading -> {
      LoadingScreen()
    }

    isError -> {
      ErrorScreen(onClickRetryButton = { trackItems.retry() })
    }

    else -> {
      LazyColumn(modifier.fillMaxSize()) {
        items(
          count = trackItems.itemCount,
          key = trackItems.itemKey(key = { track -> track.trackId }),
          contentType = trackItems.itemContentType(),
        ) { index ->
          trackItems[index]?.let { track ->
            TrackCard(
              track = track,
              onClick = {
                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(track.trackViewUrl))
                context.startActivity(browserIntent)
              },
            )

            HorizontalDivider(color = Gray300)
          }
        }

        item {
          LoadStateFooter(
            loadState = trackItems.loadState.append,
            onRetry = { trackItems.retry() },
          )
        }
      }
    }
  }
}
