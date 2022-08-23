package com.jamascrorp.harrypotteruniverse.presentation.recyclerview.viewholders

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jamascrorp.harrypotteruniverse.R
import com.jamascrorp.harrypotteruniverse.domain.entity.ImageList

class ImageBonusViewHolder(val imageView: View) : RecyclerView.ViewHolder(imageView) {

    fun bind(item: ImageList) {
        val view = imageView.findViewById<ImageView>(R.id.view)
        Glide.with(imageView.context)
            .load(item.thumbnails)
            .placeholder(R.drawable.ge1)
            .into(view)
    }
}

