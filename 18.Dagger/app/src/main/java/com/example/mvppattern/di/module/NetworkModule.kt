package com.example.mvppattern.di.module

import com.example.mvppattern.AppConstants
import com.example.mvppattern.BuildConfig
import com.example.mvppattern.mvp.model.network.Api
import com.example.mvppattern.mvp.model.network.NetworkProvider
import com.example.mvppattern.mvp.model.network.NetworkProviderImpl
import com.example.mvppattern.mvp.model.network.interceptor.AuthInterceptor
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
class NetworkModule {

    @Provides
    @Singleton
    fun provideNetworkProvider(api: Api): NetworkProvider = NetworkProviderImpl(api)

    @Provides
    @Singleton
    fun provideApi(retrofit: Retrofit): Api = retrofit.create(Api::class.java)

    @UnstableDefault
    @Provides
    @Singleton
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
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor.Level.BODY
            } else {
                HttpLoggingInterceptor.Level.NONE
            }
        }
    }

    @Provides
    @Singleton
    fun provideAuthInterceptor(): AuthInterceptor = AuthInterceptor()
}
