package com.leejihun.watcha.assignment.presentation.ui.compose.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.leejihun.watcha.assignment.domain.entity.TrackEntity
import com.leejihun.watcha.assignment.presentation.R
import com.leejihun.watcha.assignment.presentation.ui.compose.theme.Gray900
import com.leejihun.watcha.assignment.presentation.ui.compose.theme.H5
import com.leejihun.watcha.assignment.presentation.ui.compose.theme.TextLMedium
import com.leejihun.watcha.assignment.presentation.ui.compose.theme.TextXsRegular

@Composable
fun TrackCard(
  track: TrackEntity,
  onClick: (String) -> Unit,
) {
  val context = LocalContext.current

  Row(
    Modifier
      .fillMaxWidth()
      .padding(8.dp)
      .clickable { onClick(track.trackViewUrl) },
  ) {
    AsyncImage(
      modifier = Modifier
        .size(width = 160.dp, height = 160.dp)
        .padding(8.dp)
        .clip(RoundedCornerShape(8.dp)),
      model = ImageRequest.Builder(context)
        .data(track.artworkUrl60)
        .build(),
      contentScale = ContentScale.Crop,
      contentDescription = stringResource(R.string.artwork_image),
    )
    Column(
      modifier = Modifier
        .weight(1f)
        .padding(start = 12.dp, top = 16.dp),
    ) {
      Text(
        text = track.trackName,
        style = H5,
        maxLines = 2,
        overflow = TextOverflow.Ellipsis,
        color = Gray900,
      )
      Spacer(Modifier.height(8.dp))
      Text(
        text = track.collectionName,
        style = TextLMedium,
        maxLines = 2,
        overflow = TextOverflow.Ellipsis,
        color = Gray900,
      )
      Spacer(Modifier.height(8.dp))
      Text(
        text = track.artistName,
        style = TextXsRegular,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
        color = Gray900,
      )
    }
  }
}
