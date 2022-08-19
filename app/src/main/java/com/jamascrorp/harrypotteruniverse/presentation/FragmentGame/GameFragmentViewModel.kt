package com.jamascrorp.harrypotteruniverse.presentation.FragmentGame

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.jamascrorp.harrypotteruniverse.data.GameUseCaseRepositoryImpl
import com.jamascrorp.harrypotteruniverse.domain.entity.Questions
import com.jamascrorp.harrypotteruniverse.domain.usecases.CheckQuestionUseCase
import com.jamascrorp.harrypotteruniverse.domain.usecases.GetClicksUseCase
import com.jamascrorp.harrypotteruniverse.domain.usecases.GetQuestionUseCase

class GameFragmentViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = GameUseCaseRepositoryImpl(application)
    var index = 0
    var result = 0


    private val getQuestion = GetQuestionUseCase(repository)
    private val checkQuestion = CheckQuestionUseCase(repository)
    private val saveClick = GetClicksUseCase(repository)
    private val questionLiveData = MutableLiveData<Questions>()
    val questionLiveDats = questionLiveData

    fun getQuestionToPresentation() {
        questionLiveData.value = getQuestion(index)
    }

    fun cheked(select: Boolean) {

        if (checkQuestion(select, index - 1)) {
            result++
            getQuestionToPresentation()
        } else {
            getQuestionToPresentation()
        }
    }

    fun getClicks(select: Boolean) {
        saveClick(select, index)
    }
}