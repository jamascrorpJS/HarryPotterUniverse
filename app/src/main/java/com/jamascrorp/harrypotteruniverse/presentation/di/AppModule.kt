package com.jamascrorp.harrypotteruniverse.presentation.di

import android.content.Context
import com.jamascrorp.harrypotteruniverse.presentation.di.GameModule.GameSubComponent
import dagger.Module
import dagger.Provides

@Module(subcomponents = [GameSubComponent::class])
class AppModule(private val context: Context) {

    @Provides
    fun provideApplicationContext(): Context {
        return context.applicationContext
    }
}