package com.leejihun.watcha.assignment.presentation.ui.compose.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import com.leejihun.watcha.assignment.presentation.ui.compose.screens.EndOfResultScreen
import com.leejihun.watcha.assignment.presentation.ui.compose.screens.LoadErrorScreen
import com.leejihun.watcha.assignment.presentation.ui.compose.screens.LoadingScreen

@Composable
fun LoadStateFooter(
  modifier: Modifier = Modifier,
  loadState: LoadState,
  onRetryClick: () -> Unit,
) {
  Box(
    modifier = modifier
      .fillMaxWidth()
      .padding(8.dp),
  ) {
    when (loadState) {
      is LoadState.Loading -> LoadingScreen()

      is LoadState.Error -> LoadErrorScreen(onRetryClick = onRetryClick)

      else -> EndOfResultScreen()
    }
  }
}
