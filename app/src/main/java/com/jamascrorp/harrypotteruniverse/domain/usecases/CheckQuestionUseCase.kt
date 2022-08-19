package com.jamascrorp.harrypotteruniverse.domain.usecases

import com.jamascrorp.harrypotteruniverse.domain.repository.GameUseCaseRepository

class CheckQuestionUseCase(private val gameUseCaseRepository: GameUseCaseRepository) {

    operator fun invoke(select: Boolean, index: Int): Boolean {
        return gameUseCaseRepository.checkQuestion(select, index)
    }
}