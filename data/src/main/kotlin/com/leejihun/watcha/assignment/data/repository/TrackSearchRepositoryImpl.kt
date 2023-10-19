package com.leejihun.watcha.assignment.data.repository

import androidx.paging.PagingData
import androidx.paging.map
import com.leejihun.watcha.assignment.data.datasource.TrackSearchDataSource
import com.leejihun.watcha.assignment.data.mapper.toEntity
import com.leejihun.watcha.assignment.domain.entity.TrackEntity
import com.leejihun.watcha.assignment.domain.repository.TrackSearchRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import timber.log.Timber
import javax.inject.Inject

class TrackSearchRepositoryImpl @Inject constructor(
  private val dataSource: TrackSearchDataSource
) : TrackSearchRepository {
  override fun getTrackList(): Flow<PagingData<TrackEntity>> {
    return dataSource.getTrackList().map { pagingData ->
      pagingData.map { track ->
        track.toEntity()
      }
    }
  }
}
