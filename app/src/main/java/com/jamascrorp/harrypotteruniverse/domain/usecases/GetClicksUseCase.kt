package com.jamascrorp.harrypotteruniverse.domain.usecases

import com.jamascrorp.harrypotteruniverse.domain.repository.CheckClicksRepository
import com.jamascrorp.harrypotteruniverse.domain.repository.GameUseCaseRepository

class GetClicksUseCase(private val gameUseCaseRepository: GameUseCaseRepository) {

    operator fun invoke(select: Boolean, index: Int) {
        gameUseCaseRepository.saveClicks(select, index)
    }
}