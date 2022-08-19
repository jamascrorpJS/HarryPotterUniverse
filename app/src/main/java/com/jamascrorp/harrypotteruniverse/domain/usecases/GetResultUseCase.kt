package com.jamascrorp.harrypotteruniverse.domain.usecases

import com.jamascrorp.harrypotteruniverse.domain.entity.GameResult
import com.jamascrorp.harrypotteruniverse.domain.repository.GameUseCaseRepository

class GetResultUseCase(private val repository: GameUseCaseRepository) {

    operator fun invoke(answers: Int): GameResult {
        return repository.getResult(answers)
    }
}