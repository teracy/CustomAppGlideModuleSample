package com.github.teracy.customappglidemodulesample.di

import android.app.Application
import android.content.Context
import com.github.teracy.customappglidemodulesample.BuildConfig
import com.github.teracy.customappglidemodulesample.data.AppSchedulerProvider
import com.github.teracy.customappglidemodulesample.data.SchedulerProvider
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module(subcomponents = [GlideComponent::class])
internal object AppModule {
    @Singleton
    @Provides
    @JvmStatic
    fun provideContext(application: Application): Context = application

    @Provides
    @Singleton
    @JvmStatic
    fun provideInterceptor(): Interceptor = HttpLoggingInterceptor()
            .setLevel(if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BASIC else HttpLoggingInterceptor.Level.NONE)

    @Singleton
    @Provides
    @JvmStatic
    fun provideOkHttpClient(interceptor: Interceptor): OkHttpClient = OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .retryOnConnectionFailure(false)
            .addInterceptor(interceptor)
            .build()

    @Provides
    @Singleton
    @JvmStatic
    fun provideSchedulerProvider(): SchedulerProvider = AppSchedulerProvider()

    @Provides
    @Singleton
    @JvmStatic
    fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()
}
