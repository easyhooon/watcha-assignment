package com.leejihun.watcha.assignment.data.datasource

import androidx.paging.PagingData
import com.leejihun.watcha.assignment.data.model.Track
import kotlinx.coroutines.flow.Flow

interface TrackSearchDataSource {
  fun getTrackList(): Flow<PagingData<Track>>
}
