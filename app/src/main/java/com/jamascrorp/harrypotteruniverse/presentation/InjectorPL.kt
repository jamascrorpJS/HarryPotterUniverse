package com.jamascrorp.harrypotteruniverse.presentation


import android.app.Application
import com.jamascrorp.harrypotteruniverse.presentation.di.*
import com.jamascrorp.harrypotteruniverse.presentation.di.FragmentAboutCharsModule.FragmentCharsSubComponent
import com.jamascrorp.harrypotteruniverse.presentation.di.GameModule.GameSubComponent
import com.jamascrorp.harrypotteruniverse.presentation.di.Modul.ModulSubComponent
import com.jamascrorp.harrypotteruniverse.presentation.di.resultModule.ResultSubComponent

class InjectorPL : Application(), injector {
    private lateinit var component: Component


    override fun onCreate() {
        super.onCreate()
        component = DaggerComponent.builder()
            .appModule(AppModule(applicationContext))
            .build()
    }

    override fun createGameSubComponent(): GameSubComponent {
        return component.gameSubComponent().create()
    }

    override fun createResultSubComponent(): ResultSubComponent {
        return component.resultSubComponent().create()
    }

    override fun createFragmentAboutChars(): FragmentCharsSubComponent {
        return component.fragmentCharsSubComponent().create()
    }

    override fun modul(): ModulSubComponent {
        return component.modul().create()
    }
}