package com.jamascrorp.harrypotteruniverse.presentation.FragmentGame

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jamascrorp.harrypotteruniverse.domain.entity.Questions
import com.jamascrorp.harrypotteruniverse.domain.usecases.CheckQuestionUseCase
import com.jamascrorp.harrypotteruniverse.domain.usecases.GetClicksUseCase
import com.jamascrorp.harrypotteruniverse.domain.usecases.GetQuestionUseCase
import javax.inject.Inject

class GameFragmentViewModelDI @Inject constructor(
    private val getQuestionUseCase: GetQuestionUseCase,
    private val checkQuestionUseCase: CheckQuestionUseCase,
    private val getClicksUseCase: GetClicksUseCase,
) : ViewModel() {

    var index = 0
    var result = 0

    private val questionLiveData = MutableLiveData<Questions>()
    val questionLiveDats = questionLiveData

    fun getQuestionToPresentation() {
        questionLiveData.value = getQuestionUseCase(index)
    }

    fun cheked(select: Boolean) {

        if (checkQuestionUseCase(select, index - 1)) {
            result++
            getQuestionToPresentation()
        } else {
            getQuestionToPresentation()
        }
    }

    fun getClicks(select: Boolean) {
        getClicksUseCase(select, index)
    }
}