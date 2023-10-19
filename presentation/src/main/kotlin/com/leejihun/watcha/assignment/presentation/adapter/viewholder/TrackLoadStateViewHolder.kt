package com.leejihun.watcha.assignment.presentation.adapter.viewholder

import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.recyclerview.widget.RecyclerView
import com.leejihun.watcha.assignment.presentation.R
import com.leejihun.watcha.assignment.presentation.databinding.ItemTrackLoadStateBinding

class TrackLoadStateViewHolder(private val binding: ItemTrackLoadStateBinding, retry: () -> Unit) :
  RecyclerView.ViewHolder(binding.root) {

  init {
    binding.btnRetry.setOnClickListener {
      retry.invoke()
    }
  }

  fun bind(loadState: LoadState) = with(binding) {
    if (loadState is LoadState.Error) {
      tvError.text = itemView.context.getString(R.string.error_message)
    }
    pbLoadState.isVisible = loadState is LoadState.Loading
    btnRetry.isVisible = loadState is LoadState.Error
    tvError.isVisible = loadState is LoadState.Error
  }
}
