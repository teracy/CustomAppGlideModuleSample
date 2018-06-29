package com.github.teracy.customappglidemodulesample

import com.github.teracy.customappglidemodulesample.data.CustomAppGlideModule
import com.github.teracy.customappglidemodulesample.di.AppComponent
import com.github.teracy.customappglidemodulesample.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import timber.log.Timber

class App : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder()
                .application(this)
                .build()
    }

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    fun inject(appGlideModule: CustomAppGlideModule) {
        (applicationInjector() as AppComponent).glideComponentBuilder().build().inject(appGlideModule)
    }
}