package com.jamascrorp.harrypotteruniverse.presentation.di

import com.jamascrorp.harrypotteruniverse.domain.repository.CheckClicksRepository
import com.jamascrorp.harrypotteruniverse.domain.repository.GameUseCaseRepository
import com.jamascrorp.harrypotteruniverse.domain.usecases.*
import dagger.Module
import dagger.Provides


@Module
class UseCaseModule {

    @Provides
    fun provideGetQuestionUseCase(gameUseCaseRepository: GameUseCaseRepository): GetQuestionUseCase {
        return GetQuestionUseCase(gameUseCaseRepository)
    }

    @Provides
    fun provideCheckQuestionUseCase(gameUseCaseRepository: GameUseCaseRepository): CheckQuestionUseCase {
        return CheckQuestionUseCase(gameUseCaseRepository)
    }

    @Provides
    fun provideGetClicksUseCase(gameUseCaseRepository: GameUseCaseRepository): GetClicksUseCase {
        return GetClicksUseCase(gameUseCaseRepository)
    }

    @Provides
    fun provideGetResultUseCase(gameUseCaseRepository: GameUseCaseRepository): GetResultUseCase {
        return GetResultUseCase(gameUseCaseRepository)
    }

    @Provides
    fun provideGetPersonUseCase(gameUseCaseRepository: GameUseCaseRepository): GetPersonUseCase {
        return GetPersonUseCase(gameUseCaseRepository)
    }


    @Provides
    fun provideSetUseCase(checkClicksRepository: CheckClicksRepository): SetClickUseCase {
        return SetClickUseCase(checkClicksRepository)
    }
}