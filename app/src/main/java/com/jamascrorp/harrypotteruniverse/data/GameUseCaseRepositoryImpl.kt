package com.jamascrorp.harrypotteruniverse.data

import android.content.Context
import android.graphics.Bitmap
import com.jamascrorp.harrypotteruniverse.R
import com.jamascrorp.harrypotteruniverse.data.network.Person
import com.jamascrorp.harrypotteruniverse.data.network.Retrofit
import com.jamascrorp.harrypotteruniverse.domain.SaveClickOnTrueFalse
import com.jamascrorp.harrypotteruniverse.domain.entity.CorrectAnswer
import com.jamascrorp.harrypotteruniverse.domain.entity.GameResult
import com.jamascrorp.harrypotteruniverse.domain.entity.Questions
import com.jamascrorp.harrypotteruniverse.domain.repository.GameUseCaseRepository
import retrofit2.Call

class GameUseCaseRepositoryImpl(private val context: Context) : GameUseCaseRepository {

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

    override fun getQuestion(index: Int): Questions {
        val question = stringQuestions[index]
        val image = getImage(context, index)
        return Questions(question, image)
    }

    override fun checkQuestion(select: Boolean, index: Int): Boolean {
        return select == correctAnswers[index].answer
    }

    override fun getResult(answers: Int): GameResult {
        val sum = stringQuestions.size
        val percentOfTrue = (answers * 100) / sum
        return GameResult(sum, answers, percentOfTrue)
    }

    override fun saveClicks(select: Boolean, index: Int) {
        val correctAnswer = CorrectAnswer(stringQuestions[index], select)
        SaveClickOnTrueFalse.listOfClicks.add(correctAnswer)
    }

    override suspend fun getPerson(): Call<List<Person>> {
        return Retrofit.personRetrofit.getPerson("characters")
    }

    private fun getImage(context: Context, index: Int): Bitmap? {
        val images = context.assets.list("harry")?.get(index)
        return context.assetsBitmap("harry/${images}")
    }
}