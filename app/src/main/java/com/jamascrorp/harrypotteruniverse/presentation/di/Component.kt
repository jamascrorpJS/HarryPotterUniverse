package com.jamascrorp.harrypotteruniverse.presentation.di

import com.jamascrorp.harrypotteruniverse.presentation.di.FragmentAboutCharsModule.FragmentCharsSubComponent
import com.jamascrorp.harrypotteruniverse.presentation.di.GameModule.GameSubComponent
import com.jamascrorp.harrypotteruniverse.presentation.di.Modul.ModulSubComponent
import com.jamascrorp.harrypotteruniverse.presentation.di.resultModule.ResultSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    RepositoryModule::class,
    UseCaseModule::class,
    CheckClicksRepositoryModule::class,
])
interface Component {
    fun gameSubComponent(): GameSubComponent.Factory
    fun resultSubComponent(): ResultSubComponent.Factory
    fun fragmentCharsSubComponent(): FragmentCharsSubComponent.Factory
    fun modul(): ModulSubComponent.Factory
}