package com.jamascrorp.harrypotteruniverse.presentation.di.resultModule

import com.jamascrorp.harrypotteruniverse.domain.usecases.GetResultUseCase
import com.jamascrorp.harrypotteruniverse.presentation.FragmentResult.FragmentResultViewModel
import dagger.Module
import dagger.Provides

@Module
class ResultModule {
    @ResultScope
    @Provides
    fun provideGameViewModel(
        getResultUseCase: GetResultUseCase,
    ): FragmentResultViewModel {
        return FragmentResultViewModel(
            getResultUseCase
        )
    }
}