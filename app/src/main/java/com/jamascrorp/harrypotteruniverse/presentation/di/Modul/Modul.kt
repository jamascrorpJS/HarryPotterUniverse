package com.jamascrorp.harrypotteruniverse.presentation.di.Modul

import com.jamascrorp.harrypotteruniverse.domain.usecases.SetClickUseCase
import com.jamascrorp.harrypotteruniverse.presentation.FragmentFinal.FragmentFinalView
import dagger.Module
import dagger.Provides

@Module
class Modul {
    @ModulScope
    @Provides
    fun provideSetUseCase(
        setClickUseCase: SetClickUseCase
    ) : FragmentFinalView {
        return FragmentFinalView(
            setClickUseCase
        )
    }
}