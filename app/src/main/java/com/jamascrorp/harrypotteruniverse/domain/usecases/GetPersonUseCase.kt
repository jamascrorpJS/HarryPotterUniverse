package com.jamascrorp.harrypotteruniverse.domain.usecases

import com.jamascrorp.harrypotteruniverse.data.network.Person
import com.jamascrorp.harrypotteruniverse.domain.repository.GameUseCaseRepository
import retrofit2.Call

class GetPersonUseCase(val repository: GameUseCaseRepository) {


    operator fun invoke(): Call<List<Person>> {
        return repository.getPerson()
    }
}