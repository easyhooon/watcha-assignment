package com.leejihun.watcha.assignment.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.leejihun.watcha.assignment.data.model.Track
import com.leejihun.watcha.assignment.data.service.TrackSearchService
import com.leejihun.watcha.assignment.data.util.Constants
import timber.log.Timber

class TrackSearchPagingSource(
  private val service: TrackSearchService,
) : PagingSource<Int, Track>() {

  override fun getRefreshKey(state: PagingState<Int, Track>): Int? {
    return state.anchorPosition?.let { anchorPosition ->
      state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
        ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
    }
  }

  override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Track> {
    return try {
      val pageNumber = params.key ?: Constants.STARTING_PAGE_INDEX
      val response = service.getTrackList()
      val endOfPaginationReached = response.results.isEmpty()
      if (response.results.isNotEmpty()) {
        LoadResult.Page(
          data = response.results,
          prevKey = if (pageNumber == Constants.STARTING_PAGE_INDEX) null else pageNumber - 1,
          nextKey = if (endOfPaginationReached) null else pageNumber + 1,
        )
      } else {
        LoadResult.Page(
          data = emptyList(),
          prevKey = null,
          nextKey = null,
        )
      }
    } catch (exception: Exception) {
      Timber.e(exception)
      LoadResult.Error(exception)
    }
  }
}
