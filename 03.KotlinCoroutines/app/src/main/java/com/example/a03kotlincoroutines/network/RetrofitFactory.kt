package com.example.a03kotlincoroutines.network

import com.example.a03kotlincoroutines.AppConstans
import com.example.a03kotlincoroutines.BuildConfig
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.UnstableDefault
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit


object RetrofitFactory {

    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor.Level.BODY
        } else {
            HttpLoggingInterceptor.Level.NONE
        }
    }

    private val authInterceptor = Interceptor { chain ->
        val newUrl = chain.request().url
            .newBuilder()
            .addQueryParameter("api_key", AppConstans.tmdbApiKey)
            .build()
        val newRequest = chain.request()
            .newBuilder()
            .url(newUrl)
            .build()
        chain.proceed(newRequest)
    }

    private fun getOkHttpInstance(): OkHttpClient {
        return OkHttpClient()
            .newBuilder()
            .addInterceptor(authInterceptor)
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @UnstableDefault
    private fun getRetrofitClient(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(AppConstans.BASE_URL)
            .client(getOkHttpInstance())
            .addConverterFactory(Json.nonstrict.asConverterFactory(contentType = "application/json".toMediaTypeOrNull()!!))
            .build()
    }

    @UnstableDefault
    fun getMovieService() = getRetrofitClient().create(Api::class.java)
}
