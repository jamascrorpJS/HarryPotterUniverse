package com.jamascrorp.harrypotteruniverse.presentation.di

import com.jamascrorp.harrypotteruniverse.presentation.di.FragmentAboutCharsModule.FragmentCharsSubComponent
import com.jamascrorp.harrypotteruniverse.presentation.di.GameModule.GameSubComponent
import com.jamascrorp.harrypotteruniverse.presentation.di.Modul.ModulSubComponent
import com.jamascrorp.harrypotteruniverse.presentation.di.resultModule.ResultSubComponent

interface injector {
    fun createGameSubComponent(): GameSubComponent
    fun createResultSubComponent(): ResultSubComponent
    fun createFragmentAboutChars(): FragmentCharsSubComponent
    fun modul(): ModulSubComponent
}