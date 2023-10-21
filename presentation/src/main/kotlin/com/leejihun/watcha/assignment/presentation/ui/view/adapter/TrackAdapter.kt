package com.leejihun.watcha.assignment.presentation.ui.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.leejihun.watcha.assignment.domain.entity.TrackEntity
import com.leejihun.watcha.assignment.presentation.ui.view.adapter.viewholder.TrackViewHolder
import com.leejihun.watcha.assignment.presentation.databinding.ItemTrackBinding

class TrackAdapter(private val onItemClick: (String) -> Unit) : PagingDataAdapter<TrackEntity, TrackViewHolder>(TrackDiffCallback) {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrackViewHolder {
    return TrackViewHolder(
      ItemTrackBinding.inflate(LayoutInflater.from(parent.context), parent, false),
      onItemClick,
    )
  }

  override fun onBindViewHolder(holder: TrackViewHolder, position: Int) {
    getItem(position)?.let { track ->
      holder.bind(track)
    }
  }

  companion object {
    private val TrackDiffCallback = object : DiffUtil.ItemCallback<TrackEntity>() {
      override fun areItemsTheSame(
        oldItem: TrackEntity,
        newItem: TrackEntity,
      ): Boolean {
        return oldItem.trackId == newItem.trackId
      }

      override fun areContentsTheSame(
        oldItem: TrackEntity,
        newItem: TrackEntity,
      ): Boolean {
        return oldItem == newItem
      }
    }
  }
}
