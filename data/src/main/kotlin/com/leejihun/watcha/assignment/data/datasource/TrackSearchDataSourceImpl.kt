package com.leejihun.watcha.assignment.data.datasource

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.leejihun.watcha.assignment.data.model.Track
import com.leejihun.watcha.assignment.data.paging.TrackSearchPagingSource
import com.leejihun.watcha.assignment.data.service.TrackSearchService
import com.leejihun.watcha.assignment.data.util.Constants
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TrackSearchDataSourceImpl @Inject constructor(
  private val service: TrackSearchService,
) : TrackSearchDataSource {
  override fun getTrackList(): Flow<PagingData<Track>> {
    val pagingSourceFactory = { TrackSearchPagingSource(service) }

    return Pager(
      config = PagingConfig(
        pageSize = Constants.PAGING_SIZE,
        enablePlaceholders = false,
        maxSize = Constants.PAGING_SIZE * 3,
      ),
      pagingSourceFactory = pagingSourceFactory,
    ).flow
  }
}
