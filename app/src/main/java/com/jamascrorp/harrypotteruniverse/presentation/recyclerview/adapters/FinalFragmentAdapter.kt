package com.jamascrorp.harrypotteruniverse.presentation.recyclerview.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jamascrorp.harrypotteruniverse.R
import com.jamascrorp.harrypotteruniverse.data.GameUseCaseRepositoryImpl
import com.jamascrorp.harrypotteruniverse.domain.SaveClickOnTrueFalse
import com.jamascrorp.harrypotteruniverse.presentation.recyclerview.viewholders.FinalFragmentViewHolder

class FinalFragmentAdapter(private val context: Context) :
    RecyclerView.Adapter<FinalFragmentViewHolder>() {

    private val listOfClicks = SaveClickOnTrueFalse.listOfClicks
    private val repositoryImpl = GameUseCaseRepositoryImpl(context)

    val trues = context.getString(R.string.trues)
    val falses = context.getString(R.string.falsees)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FinalFragmentViewHolder {
        val layout = when (viewType) {
            TRUE_LIST -> R.layout.list_true
            FALSE_LIST -> R.layout.list_falls
            else -> throw Exception("Layout not found")
        }
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(layout, parent, false)
        return FinalFragmentViewHolder(view)
    }

    override fun onBindViewHolder(holder: FinalFragmentViewHolder, position: Int) {
        val item = listOfClicks[position]
        val text = context.getString(R.string.choice, clickText(position, trues, falses))
        holder.question.text = item.question
        holder.select.text = text
    }

    override fun getItemViewType(position: Int): Int {
        return when (repositoryImpl.checkClicks(position)) {
            true -> TRUE_LIST
            false -> FALSE_LIST
        }
    }

    override fun getItemCount(): Int {
        return listOfClicks.size
    }

    companion object {
        fun clickText(position: Int, str: String, str1: String): String {
            return when (SaveClickOnTrueFalse.listOfClicks[position].answer) {
                true -> str
                false -> str1
            }
        }

        const val TRUE_LIST = 1
        const val FALSE_LIST = 0
    }
}