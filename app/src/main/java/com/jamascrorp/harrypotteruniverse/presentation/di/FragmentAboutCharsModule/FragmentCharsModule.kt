package com.jamascrorp.harrypotteruniverse.presentation.di.FragmentAboutCharsModule

import com.jamascrorp.harrypotteruniverse.domain.usecases.GetPersonUseCase
import com.jamascrorp.harrypotteruniverse.presentation.FragmentAboutChars.AboutCharsFragmentViewModel
import dagger.Module
import dagger.Provides

@Module
class FragmentCharsModule {
    @FragmentCharsScope
    @Provides
    fun provideGetPersonUseCase(
        getPersonUseCase: GetPersonUseCase,
    ): AboutCharsFragmentViewModel {
        return AboutCharsFragmentViewModel(
            getPersonUseCase
        )
    }
}