package com.jamascrorp.harrypotteruniverse.presentation.recyclerview.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.jamascrorp.harrypotteruniverse.R
import com.jamascrorp.harrypotteruniverse.domain.entity.ImageList
import com.jamascrorp.harrypotteruniverse.presentation.recyclerview.ImageListDiffUtilItemCallback
import com.jamascrorp.harrypotteruniverse.presentation.recyclerview.viewholders.ImageBonusViewHolder

class ImageBonusAdapter :
    ListAdapter<ImageList, ImageBonusViewHolder>(ImageListDiffUtilItemCallback()) {

    var select: ((string: String?) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageBonusViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.list_pictures, parent, false)
        return ImageBonusViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImageBonusViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
        holder.imageView.setOnClickListener {
            select?.invoke(item.image)
        }
    }
}