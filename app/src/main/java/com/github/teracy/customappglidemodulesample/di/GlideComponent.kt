package com.github.teracy.customappglidemodulesample.di

import com.github.teracy.customappglidemodulesample.data.CustomAppGlideModule
import dagger.Subcomponent

@Subcomponent
interface GlideComponent {
    fun inject(appGlideModule: CustomAppGlideModule)

    @Subcomponent.Builder
    interface Builder {
        fun build(): GlideComponent
    }
}