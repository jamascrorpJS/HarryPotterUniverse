package com.jamascrorp.harrypotteruniverse.presentation.FragmentFinal

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.jamascrorp.harrypotteruniverse.domain.usecases.SetClickUseCase
import com.jamascrorp.harrypotteruniverse.presentation.recyclerview.adapters.FinalFragmentAdapter
import com.jamascrorp.harrypotteruniverse.presentation.recyclerview.viewholders.FinalFragmentViewHolder
import javax.inject.Inject

class FragmentFinalView @Inject constructor(private val setClicksUseCase: SetClickUseCase) :
    ViewModel() {


    fun adapter(context: Context): RecyclerView.Adapter<FinalFragmentViewHolder> {
        return FinalFragmentAdapter(context, setClicksUseCase)
    }
}