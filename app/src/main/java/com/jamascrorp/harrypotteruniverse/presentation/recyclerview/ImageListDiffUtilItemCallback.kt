package com.jamascrorp.harrypotteruniverse.presentation.recyclerview

import androidx.recyclerview.widget.DiffUtil
import com.jamascrorp.harrypotteruniverse.domain.entity.ImageList

class ImageListDiffUtilItemCallback : DiffUtil.ItemCallback<ImageList>() {

    override fun areItemsTheSame(oldItem: ImageList, newItem: ImageList): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: ImageList, newItem: ImageList): Boolean {
        return oldItem == newItem
    }
}