package com.leejihun.watcha.assignment.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.leejihun.watcha.assignment.data.model.Track
import com.leejihun.watcha.assignment.data.service.TrackSearchService
import com.leejihun.watcha.assignment.data.util.Constants.PAGING_SIZE
import com.leejihun.watcha.assignment.data.util.Constants.STARTING_PAGE_INDEX
import retrofit2.HttpException
import timber.log.Timber
import java.io.IOException

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
      val pageNumber = params.key ?: STARTING_PAGE_INDEX
      val response = service.getTrackList(limit = params.loadSize)

      val endOfPaginationReached = response.results.isEmpty()

      LoadResult.Page(
        data = response.results,
        prevKey = if (pageNumber == STARTING_PAGE_INDEX) null else pageNumber - 1,
        nextKey = if (endOfPaginationReached) {
          null
        } else {
          // initial load size = 3 * NETWORK_PAGE_SIZE
          // ensure we're not requesting duplicating items, at the 2nd request
           pageNumber + (params.loadSize / PAGING_SIZE )
        }
      )
    } catch (exception: IOException) {
      Timber.e(exception)
      LoadResult.Error(exception)
    } catch (exception: HttpException) {
      Timber.e(exception)
      LoadResult.Error(exception)
    }
  }
}
