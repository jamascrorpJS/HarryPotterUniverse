package com.jamascrorp.harrypotteruniverse.presentation.recyclerview.viewholders

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jamascrorp.harrypotteruniverse.R

class FinalFragmentViewHolder(indexView: View) : RecyclerView.ViewHolder(indexView) {

    val question = indexView.findViewById<TextView>(R.id.question_true)
    val select = indexView.findViewById<TextView>(R.id.select_true)

}