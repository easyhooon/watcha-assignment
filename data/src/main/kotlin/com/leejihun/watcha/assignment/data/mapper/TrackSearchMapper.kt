package com.leejihun.watcha.assignment.data.mapper

import com.leejihun.watcha.assignment.data.model.Track
import com.leejihun.watcha.assignment.domain.entity.TrackEntity

internal fun Track.toEntity(): TrackEntity {
  return TrackEntity(
    trackId = trackId,
    artistName = artistName,
    collectionName = collectionName,
    trackName = trackName,
    artworkUrl60 = artworkUrl60,
    trackViewUrl = trackViewUrl,
  )
}
