package com.leejihun.watcha.assignment.presentation.ui.compose.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun LoadingScreen(
  modifier: Modifier = Modifier,
) {
  Box(
    modifier = modifier.fillMaxWidth(),
    contentAlignment = Alignment.Center,
  ) {
    CircularProgressIndicator()
  }
}
