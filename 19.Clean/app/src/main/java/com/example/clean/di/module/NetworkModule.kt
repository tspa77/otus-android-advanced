package com.example.clean.di.module

import com.example.clean.domain.AppConstants
import com.example.clean.BuildConfig
import com.example.clean.data.service.Api
import com.example.clean.domain.provider.NetworkProvider
import com.example.clean.domain.provider.NetworkProviderImpl
import com.example.clean.data.service.interceptor.AuthInterceptor
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import kotlinx.serialization.UnstableDefault
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import javax.inject.Singleton


@UnstableDefault
@Module
object NetworkModule {

    @Provides
    @Singleton
    @JvmStatic
    fun provideNetworkProvider(api: Api): NetworkProvider =
        NetworkProviderImpl(api)

    @Provides
    @Singleton
    @JvmStatic
    fun provideApi(retrofit: Retrofit): Api = retrofit.create(
        Api::class.java)

    @UnstableDefault
    @Provides
    @Singleton
    @JvmStatic
    fun provideRetrofit(okHttp: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(AppConstants.BASE_URL)
            .client(okHttp)
            .addConverterFactory(
                Json.nonstrict.asConverterFactory(
                    contentType = "application/json".toMediaTypeOrNull()!!
                )
            )
            .build()
    }

    @Provides
    @Singleton
    @JvmStatic
    fun provideOkHtpClient(
        loggingInterceptor: HttpLoggingInterceptor,
        authInterceptor: AuthInterceptor
    ): OkHttpClient {
        return OkHttpClient()
            .newBuilder()
            .addInterceptor(authInterceptor)
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @Provides
    @Singleton
    @JvmStatic
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor.Level.BODY
            } else {
                HttpLoggingInterceptor.Level.NONE
            }
        }
    }
}
