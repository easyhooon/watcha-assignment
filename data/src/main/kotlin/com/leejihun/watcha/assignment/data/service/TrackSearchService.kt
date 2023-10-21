package com.leejihun.watcha.assignment.data.service

import com.leejihun.watcha.assignment.data.model.TrackSearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface TrackSearchService {

  @GET("search")
  suspend fun getTrackList(
    @Query("term") term: String = "greenday",
    @Query("entity") entity: String = "song",
    @Query("limit") limit: Int,
  ): TrackSearchResponse
}
