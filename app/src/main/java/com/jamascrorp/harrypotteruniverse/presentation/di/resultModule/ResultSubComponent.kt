package com.jamascrorp.harrypotteruniverse.presentation.di.resultModule

import com.jamascrorp.harrypotteruniverse.presentation.FragmentResult.ResultFragment
import dagger.Subcomponent


@ResultScope
@Subcomponent(modules = [ResultModule::class])
interface ResultSubComponent {
    fun inject(resultFragment: ResultFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create(): ResultSubComponent
    }
}