package com.jamascrorp.harrypotteruniverse.presentation.di

import android.content.Context
import com.jamascrorp.harrypotteruniverse.data.CheckClicksRepositoryImpl
import com.jamascrorp.harrypotteruniverse.domain.repository.CheckClicksRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CheckClicksRepositoryModule {
    @Singleton
    @Provides
    fun provideRepositoryImpl(
        context: Context,
    ): CheckClicksRepository {
        return CheckClicksRepositoryImpl(
            context.applicationContext
        )
    }
}
