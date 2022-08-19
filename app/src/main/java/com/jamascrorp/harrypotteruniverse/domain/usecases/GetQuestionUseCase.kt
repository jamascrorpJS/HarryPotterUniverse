package com.jamascrorp.harrypotteruniverse.domain.usecases

import com.jamascrorp.harrypotteruniverse.domain.entity.Questions
import com.jamascrorp.harrypotteruniverse.domain.repository.GameUseCaseRepository

class GetQuestionUseCase(private val repository: GameUseCaseRepository) {

    operator fun invoke(index: Int): Questions {
        return repository.getQuestion(index)
    }
}