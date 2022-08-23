package com.jamascrorp.harrypotteruniverse.presentation.FragmentResult

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jamascrorp.harrypotteruniverse.domain.entity.GameResult
import com.jamascrorp.harrypotteruniverse.domain.usecases.GetResultUseCase
import javax.inject.Inject

class FragmentResultViewModel @Inject constructor(private val getResultUseCase: GetResultUseCase) :
    ViewModel() {

    val liveData = MutableLiveData<GameResult>()
    val LiveData1 = liveData

    fun resultToPresentation(args: Int) {
        liveData.value = getResultUseCase(args)
    }

}