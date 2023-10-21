package com.leejihun.watcha.assignment.presentation.ui.view.adapter.viewholder

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.leejihun.watcha.assignment.domain.entity.TrackEntity
import com.leejihun.watcha.assignment.presentation.databinding.ItemTrackBinding

class TrackViewHolder(
  private val binding: ItemTrackBinding,
  private val onItemClick: (String) -> Unit,
) : RecyclerView.ViewHolder(binding.root) {

  private lateinit var currentItem: TrackEntity

  init {
    binding.root.setOnClickListener {
      onItemClick(currentItem.trackViewUrl)
    }
  }

  fun bind(track: TrackEntity) {
    currentItem = track
    itemView.apply {
      binding.apply {
        ivArtwork.load(track.artworkUrl60)
        tvTrackName.text = track.trackName
        tvCollectionName.text = track.collectionName
        tvArtiestName.text = track.artistName
      }
    }
  }
}
