package com.github.teracy.customappglidemodulesample.di.activitymodule

import com.github.teracy.customappglidemodulesample.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface MainActivityBuilder {
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    fun contributeMainActivity(): MainActivity
}