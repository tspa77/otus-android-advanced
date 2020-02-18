package com.example.clean.di.module

import com.example.clean.BuildConfig
import com.example.clean.data.repository.RepositoryImpl
import com.example.clean.data.interceptor.AuthInterceptor
import com.example.clean.domain.api.Api
import com.example.clean.AppConstants
import com.example.clean.domain.repo.Repository
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
object RepositoryModule {

    @Provides
    @Singleton
    @JvmStatic
    fun provideRepository(api: Api): Repository =
        RepositoryImpl(api)

    @Provides
    @Singleton
    @JvmStatic
    fun provideApi(retrofit: Retrofit): Api = retrofit.create(
        Api::class.java
    )

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
