package com.leejihun.watcha.assignment.presentation

import androidx.lifecycle.ViewModel
import com.leejihun.watcha.assignment.domain.usecase.GetTrackListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
  getTrackListUseCase: GetTrackListUseCase,
) : ViewModel() {

  val trackList = getTrackListUseCase()
}
