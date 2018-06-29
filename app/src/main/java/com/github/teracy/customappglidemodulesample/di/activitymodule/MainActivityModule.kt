package com.github.teracy.customappglidemodulesample.di.activitymodule

import android.arch.lifecycle.ViewModel
import android.support.v7.app.AppCompatActivity
import com.github.teracy.customappglidemodulesample.di.ViewModelMapKey
import com.github.teracy.customappglidemodulesample.ui.MainActivity
import com.github.teracy.customappglidemodulesample.ui.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface MainActivityModule {
    @Binds
    fun provideAppCompatActivity(mainActivity: MainActivity): AppCompatActivity

    @Binds
    @IntoMap
    @ViewModelMapKey(MainViewModel::class)
    fun bindMainViewModel(mainViewModel: MainViewModel): ViewModel
}