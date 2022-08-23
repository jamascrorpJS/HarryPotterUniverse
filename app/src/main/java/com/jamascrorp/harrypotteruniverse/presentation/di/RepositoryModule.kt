package com.jamascrorp.harrypotteruniverse.presentation.di

import android.content.Context
import com.jamascrorp.harrypotteruniverse.data.GameUseCaseRepositoryImpl
import com.jamascrorp.harrypotteruniverse.domain.repository.GameUseCaseRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideRepositoryImpl(
        context: Context,
    ): GameUseCaseRepository {
        return GameUseCaseRepositoryImpl(
            context.applicationContext,
        )
    }
}