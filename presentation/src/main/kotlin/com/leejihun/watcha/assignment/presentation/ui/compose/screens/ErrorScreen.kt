package com.leejihun.watcha.assignment.presentation.ui.compose.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.leejihun.watcha.assignment.presentation.R
import com.leejihun.watcha.assignment.presentation.ui.compose.theme.Title

@Composable
fun ErrorScreen(
  modifier: Modifier = Modifier,
  onClickRetryButton: () -> Unit,
) {
  Box(
    modifier = modifier.fillMaxWidth(),
    contentAlignment = Alignment.Center,
  ) {
    Column(
      horizontalAlignment = Alignment.CenterHorizontally,
      verticalArrangement = Arrangement.Center,
    ) {
      Text(
        text = stringResource(id = R.string.error_message),
        style = Title,
      )
      Spacer(modifier.height(12.dp))
      Button(onClick = onClickRetryButton) {
        Text(
          text = stringResource(id = R.string.retry),
          style = TextStyle(fontSize = 16.sp)
        )
      }
    }
  }
}
