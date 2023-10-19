package com.leejihun.watcha.assignment.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Track(
  @SerialName("artistName")
  val artistName: String,

  @SerialName("collectionName")
  val collectionName: String,

  @SerialName("trackName")
  val trackName: String,

  @SerialName("artworkUrl60")
  val artworkUrl60: String,

  @SerialName("collectionPrice")
  val collectionPrice: Double,
)
