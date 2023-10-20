package com.leejihun.watcha.assignment.domain.repository

import androidx.paging.PagingData
import com.leejihun.watcha.assignment.domain.entity.TrackEntity
import kotlinx.coroutines.flow.Flow

interface TrackSearchRepository {
  fun getTrackList(): Flow<PagingData<TrackEntity>>
}
