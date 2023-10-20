package com.leejihun.watcha.assignment.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import com.leejihun.watcha.assignment.presentation.adapter.viewholder.TrackLoadStateViewHolder
import com.leejihun.watcha.assignment.presentation.databinding.ItemTrackLoadStateBinding

class TrackLoadStateAdapter(private val retry: () -> Unit) :
  LoadStateAdapter<TrackLoadStateViewHolder>() {

  override fun onCreateViewHolder(
    parent: ViewGroup,
    loadState: LoadState,
  ): TrackLoadStateViewHolder {
    return TrackLoadStateViewHolder(ItemTrackLoadStateBinding.inflate(LayoutInflater.from(parent.context), parent, false), retry)
  }

  override fun onBindViewHolder(holder: TrackLoadStateViewHolder, loadState: LoadState) {
    holder.bind(loadState)
  }
}
