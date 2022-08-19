package com.jamascrorp.harrypotteruniverse.domain.repository

import com.jamascrorp.harrypotteruniverse.data.network.Person
import com.jamascrorp.harrypotteruniverse.domain.entity.GameResult
import com.jamascrorp.harrypotteruniverse.domain.entity.Questions
import retrofit2.Call

interface GameUseCaseRepository {


    fun getQuestion(index: Int): Questions

    fun getResult(answers: Int): GameResult

    fun checkQuestion(select: Boolean, index: Int): Boolean

    fun saveClicks(select: Boolean, index: Int)

    fun getPerson(): Call<List<Person>>

}