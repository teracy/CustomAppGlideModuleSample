package com.github.teracy.customappglidemodulesample.di

import android.app.Application
import com.github.teracy.customappglidemodulesample.App
import com.github.teracy.customappglidemodulesample.di.activitymodule.MainActivityBuilder
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    AppModule::class,
    MainActivityBuilder::class,
    ViewModelModule::class
])
interface AppComponent : AndroidInjector<App> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    override fun inject(application: App)
}