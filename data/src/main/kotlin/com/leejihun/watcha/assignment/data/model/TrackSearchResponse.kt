package com.leejihun.watcha.assignment.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TrackSearchResponse(
  @SerialName("resultCount")
  val resultCount: Int,

  @SerialName("results")
  val results: List<Track>,
)
