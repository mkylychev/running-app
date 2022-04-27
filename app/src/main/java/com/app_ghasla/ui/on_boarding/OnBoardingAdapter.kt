package com.app_ghasla.ui.on_boarding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.app_ghasla.core.extension.setImage
import com.app_ghasla.core.model.OnBoardingItem
import com.app_ghasla.databinding.AdapterOnBoardingBinding

class OnBoardingAdapter :
    ListAdapter<OnBoardingItem, OnBoardingAdapter.OnBoardingViewHolder>(OnBoardingDiffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = OnBoardingViewHolder(
        AdapterOnBoardingBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class OnBoardingViewHolder(
        private val binding: AdapterOnBoardingBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(onBoardingItem: OnBoardingItem) = with(binding) {
            vImage.setImage(onBoardingItem.drawable)
            tvTitle.text = onBoardingItem.title
        }
    }

    object OnBoardingDiffUtil : DiffUtil.ItemCallback<OnBoardingItem>() {
        override fun areItemsTheSame(oldItem: OnBoardingItem, newItem: OnBoardingItem) =
            oldItem == newItem

        override fun areContentsTheSame(oldItem: OnBoardingItem, newItem: OnBoardingItem) =
            oldItem.equals(newItem)
    }
}