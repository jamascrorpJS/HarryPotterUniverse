package com.jamascrorp.harrypotteruniverse.domain.entity

data class GameResult(
    val sumQuestions: Int,
    val trueAnswer: Int,
    val percentOfTrueAnswer: Int
)