package com.jamascrorp.harrypotteruniverse.domain.usecases

import com.jamascrorp.harrypotteruniverse.domain.repository.CheckClicksRepository

class SetClickUseCase(private val checkClicksRepository: CheckClicksRepository) {

    operator fun invoke(index: Int) : Boolean{
        return checkClicksRepository.checkClicks(index)
    }
}