package com.jamascrorp.harrypotteruniverse.presentation.di.GameModule

import com.jamascrorp.harrypotteruniverse.presentation.FragmentGame.GameFragment
import dagger.Subcomponent

@GameScope
@Subcomponent(modules = [GameModule::class])
interface GameSubComponent {
    fun inject(gameFragment: GameFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create(): GameSubComponent
    }
}