package com.leejihun.watcha.assignment.presentation.adapter.viewholder

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.leejihun.watcha.assignment.domain.entity.TrackEntity
import com.leejihun.watcha.assignment.presentation.databinding.ItemTrackBinding

class TrackViewHolder(private val binding: ItemTrackBinding) :
  RecyclerView.ViewHolder(binding.root) {

  fun bind(track: TrackEntity) {
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
