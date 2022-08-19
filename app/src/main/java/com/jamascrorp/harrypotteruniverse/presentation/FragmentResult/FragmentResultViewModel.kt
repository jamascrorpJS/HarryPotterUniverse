package com.jamascrorp.harrypotteruniverse.presentation.FragmentResult

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.jamascrorp.harrypotteruniverse.data.GameUseCaseRepositoryImpl
import com.jamascrorp.harrypotteruniverse.domain.entity.GameResult
import com.jamascrorp.harrypotteruniverse.domain.usecases.GetResultUseCase

class FragmentResultViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = GameUseCaseRepositoryImpl(application)

    val getResult = GetResultUseCase(repository)
    val liveData = MutableLiveData<GameResult>()
    val LiveData1 = liveData

    fun resultToPresentation(args: Int) {
        liveData.value = getResult(args)
    }

}