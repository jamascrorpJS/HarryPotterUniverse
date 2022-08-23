package com.jamascrorp.harrypotteruniverse.presentation.di.FragmentAboutCharsModule

import com.jamascrorp.harrypotteruniverse.presentation.FragmentAboutChars.AboutCharsFragment
import dagger.Subcomponent

@FragmentCharsScope
@Subcomponent(modules = [FragmentCharsModule::class])
interface FragmentCharsSubComponent {
    fun inject(aboutCharsFragment: AboutCharsFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create(): FragmentCharsSubComponent
    }
}