package com.jamascrorp.harrypotteruniverse.presentation.di.Modul

import com.jamascrorp.harrypotteruniverse.presentation.FragmentFinal.FinalFragment
import dagger.Subcomponent

@ModulScope
@Subcomponent(modules = [Modul::class])
interface ModulSubComponent {
    fun inject(finalFragment: FinalFragment)

    @Subcomponent.Factory
    interface Factory{
        fun create(): ModulSubComponent
    }
}