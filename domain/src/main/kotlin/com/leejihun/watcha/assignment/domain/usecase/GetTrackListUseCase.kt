package com.leejihun.watcha.assignment.domain.usecase

import androidx.paging.PagingData
import com.leejihun.watcha.assignment.domain.entity.TrackEntity
import com.leejihun.watcha.assignment.domain.repository.TrackSearchRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetTrackListUseCase @Inject constructor(
  private val repository: TrackSearchRepository,
) {
  operator fun invoke(): Flow<PagingData<TrackEntity>> {
    return repository.getTrackList()
  }
}
