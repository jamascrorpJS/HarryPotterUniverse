package com.jamascrorp.harrypotteruniverse.presentation.recyclerview.viewholders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jamascrorp.harrypotteruniverse.R

class FragmentAboutView(view: View) : RecyclerView.ViewHolder(view) {
    val name = view.findViewById<TextView>(R.id.header_title)
    val alternateNames = view.findViewById<TextView>(R.id.alternate_name1)
    val species = view.findViewById<TextView>(R.id.species1)
    val gender = view.findViewById<TextView>(R.id.gender1)
    val house = view.findViewById<TextView>(R.id.house1)
    val dateBirth = view.findViewById<TextView>(R.id.date_birth1)
    val yearBith = view.findViewById<TextView>(R.id.birth1)
    val wizards = view.findViewById<TextView>(R.id.wizars1)
    val ancestry = view.findViewById<TextView>(R.id.ancestry1)
    val wand = view.findViewById<TextView>(R.id.wand1)
    val patronus = view.findViewById<TextView>(R.id.patr1)
    val students = view.findViewById<TextView>(R.id.student1)
    val staff = view.findViewById<TextView>(R.id.staff1)
    val actor = view.findViewById<TextView>(R.id.actor1)
    val alive = view.findViewById<TextView>(R.id.alive1)
    val image = view.findViewById<ImageView>(R.id.image)
    val alternateNames1 = view.findViewById<TextView>(R.id.alternate_name)
    val species1 = view.findViewById<TextView>(R.id.species)
    val gender1 = view.findViewById<TextView>(R.id.gender)
    val house1 = view.findViewById<TextView>(R.id.house)
    val dateBirth1 = view.findViewById<TextView>(R.id.date_birth)
    val yearBith1 = view.findViewById<TextView>(R.id.birth)
    val wizards1 = view.findViewById<TextView>(R.id.wizars)
    val ancestry1 = view.findViewById<TextView>(R.id.ancestry)
    val wand1 = view.findViewById<TextView>(R.id.wand)
    val patronus1 = view.findViewById<TextView>(R.id.patr)
    val students1 = view.findViewById<TextView>(R.id.student)
    val staff1 = view.findViewById<TextView>(R.id.staff)
    val actor1 = view.findViewById<TextView>(R.id.actor)
    val alive1 = view.findViewById<TextView>(R.id.alive)
}
