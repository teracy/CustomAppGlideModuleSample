package com.github.teracy.customappglidemodulesample.di

import android.arch.lifecycle.ViewModel
import dagger.MapKey
import kotlin.reflect.KClass

@MapKey
annotation class ViewModelMapKey(val value: KClass<out ViewModel>)