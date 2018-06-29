package com.github.teracy.customappglidemodulesample.data

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.Registry
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.module.AppGlideModule
import com.github.teracy.customappglidemodulesample.App
import okhttp3.OkHttpClient
import java.io.InputStream
import javax.inject.Inject

@GlideModule(glideName = "CustomGlideApp")
class CustomAppGlideModule : AppGlideModule() {
    @Inject
    lateinit var okHttpClient: OkHttpClient

    override fun isManifestParsingEnabled() = false

    override fun registerComponents(context: Context, glide: Glide, registry: Registry) {
        super.registerComponents(context, glide, registry)
        (context.applicationContext as App).inject(this)
        glide.registry.replace(GlideUrl::class.java, InputStream::class.java, OkHttpUrlLoader.Factory(okHttpClient))
    }
}