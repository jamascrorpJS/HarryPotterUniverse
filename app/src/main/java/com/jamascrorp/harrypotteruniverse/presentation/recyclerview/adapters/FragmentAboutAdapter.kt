package com.jamascrorp.harrypotteruniverse.presentation.recyclerview.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.jamascrorp.harrypotteruniverse.R
import com.jamascrorp.harrypotteruniverse.data.network.Person
import com.jamascrorp.harrypotteruniverse.presentation.recyclerview.viewholders.FragmentAboutView
import java.util.*

class FragmentAboutAdapter(private val person: List<Person>) : RecyclerView.Adapter<FragmentAboutView>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FragmentAboutView {
        val layoutInflater =
            LayoutInflater.from(parent.context).inflate(R.layout.list_char, parent, false)
        return FragmentAboutView(layoutInflater)
    }

    override fun onBindViewHolder(holder: FragmentAboutView, position: Int) {
        val item = person[position]
        holder.name.text = item.name
        holder.alternateNames.text = item.alternateNames.joinToString { it }
        holder.species.text = item.species
        holder.gender.text = item.gender
        holder.house.text = item.house
        holder.dateBirth.text = item.dateBirth
        holder.yearBith.text = item.yearBirth.toString().dropLast(2)
        holder.wizards.text = translate(item.wizards)
        holder.ancestry.text = item.ancestry
        holder.wand.text = holder.itemView.context.getString(R.string.Wand,
            item.wand?.wood,
            item.wand?.core,
            item.wand?.length.toString()).dropLast(2 )
        holder.patronus.text = item.patronus
        holder.students.text = translate(item.hogwartsStudent)
        holder.staff.text = translate(item.hogwartsStaff)
        holder.actor.text = item.actor
        holder.alive.text = translate(item.alive)
        Glide.with(holder.itemView.context)
            .load(item.image)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .placeholder(R.drawable.harry)
            .into(holder.image)

        holder.alternateNames1.text = holder.itemView.context.getString(R.string.alternate)
        holder.species1.text = holder.itemView.context.getString(R.string.species)
        holder.gender1.text = holder.itemView.context.getString(R.string.gender)
        holder.house1.text = holder.itemView.context.getString(R.string.house)
        holder.dateBirth1.text = holder.itemView.context.getString(R.string.date)
        holder.yearBith1.text = holder.itemView.context.getString(R.string.birth)
        holder.wizards1.text = holder.itemView.context.getString(R.string.wizards)
        holder.ancestry1.text = holder.itemView.context.getString(R.string.ancestry)
        holder.wand1.text = holder.itemView.context.getString(R.string.wand)
        holder.patronus1.text = holder.itemView.context.getString(R.string.patronous)
        holder.students1.text = holder.itemView.context.getString(R.string.student)
        holder.staff1.text = holder.itemView.context.getString(R.string.staffs)
        holder.actor1.text = holder.itemView.context.getString(R.string.actor)
        holder.alive1.text = holder.itemView.context.getString(R.string.alive)
    }

    override fun getItemCount(): Int {
        return person.size
    }

    companion object {
       private fun translate(item:Boolean):String {
            return when(Locale.getDefault().language) {
                "ru" -> if (item) "Да" else "Нет"
                else -> if (item) "true" else "false"
            }
        }
    }
}