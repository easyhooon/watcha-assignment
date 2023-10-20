package com.leejihun.watcha.assignment.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.leejihun.watcha.assignment.domain.usecase.GetTrackListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TrackListViewModel @Inject constructor(
  getTrackListUseCase: GetTrackListUseCase,
) : ViewModel() {

  private val _refreshClickEvent = MutableSharedFlow<Unit>()
  val refreshClickEvent: SharedFlow<Unit> = _refreshClickEvent.asSharedFlow()

  val trackList = getTrackListUseCase().cachedIn(viewModelScope)

  fun refresh() {
    viewModelScope.launch {
      _refreshClickEvent.emit(Unit)
    }
  }
}
