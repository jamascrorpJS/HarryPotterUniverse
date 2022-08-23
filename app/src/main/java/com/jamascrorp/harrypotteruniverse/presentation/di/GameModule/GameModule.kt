package com.jamascrorp.harrypotteruniverse.presentation.di.GameModule

import com.jamascrorp.harrypotteruniverse.domain.usecases.CheckQuestionUseCase
import com.jamascrorp.harrypotteruniverse.domain.usecases.GetClicksUseCase
import com.jamascrorp.harrypotteruniverse.domain.usecases.GetQuestionUseCase
import com.jamascrorp.harrypotteruniverse.presentation.FragmentGame.GameFragmentViewModelDI
import dagger.Module
import dagger.Provides

@Module
class GameModule {
    @GameScope
    @Provides
    fun provideGameViewModel(
        getQuestionUseCase: GetQuestionUseCase,
        checkQuestionUseCase: CheckQuestionUseCase,
        getClicksUseCase: GetClicksUseCase,
    ): GameFragmentViewModelDI {
        return GameFragmentViewModelDI(
            getQuestionUseCase,
            checkQuestionUseCase,
            getClicksUseCase
        )
    }
}