package com.jamascrorp.harrypotteruniverse.data

import android.content.Context
import com.jamascrorp.harrypotteruniverse.R
import com.jamascrorp.harrypotteruniverse.domain.SaveClickOnTrueFalse
import com.jamascrorp.harrypotteruniverse.domain.entity.CorrectAnswer
import com.jamascrorp.harrypotteruniverse.domain.repository.CheckClicksRepository

class CheckClicksRepositoryImpl(context: Context) : CheckClicksRepository {

    private val stringQuestions: Array<String> = context.resources.getStringArray(R.array.question)

    private val correctAnswers = listOf(
        CorrectAnswer(stringQuestions[0], true),
        CorrectAnswer(stringQuestions[1], true),
        CorrectAnswer(stringQuestions[2], true),
        CorrectAnswer(stringQuestions[3], false),
        CorrectAnswer(stringQuestions[4], true),
        CorrectAnswer(stringQuestions[5], true),
        CorrectAnswer(stringQuestions[6], false),
        CorrectAnswer(stringQuestions[7], false),
        CorrectAnswer(stringQuestions[8], true),
        CorrectAnswer(stringQuestions[9], true),
        CorrectAnswer(stringQuestions[10], true),
        CorrectAnswer(stringQuestions[11], false),
        CorrectAnswer(stringQuestions[12], false),
    )

    override fun checkClicks(index: Int): Boolean {
        return correctAnswers[index].answer == SaveClickOnTrueFalse.listOfClicks[index].answer
    }
}