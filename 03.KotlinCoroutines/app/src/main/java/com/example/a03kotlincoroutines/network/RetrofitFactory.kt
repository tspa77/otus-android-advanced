package com.example.a03kotlincoroutines.network

import com.example.a03kotlincoroutines.BuildConfig
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.io.IOException
import kotlinx.serialization.UnstableDefault
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit


class RetrofitFactory {
    companion object {
        private fun getOkHttpInstance(): OkHttpClient {
            return OkHttpClient()
                .newBuilder()
                .addInterceptor(HttpLoggingInterceptor().apply {
                    level = if (BuildConfig.DEBUG) {
                        HttpLoggingInterceptor.Level.BODY
                    } else {
                        HttpLoggingInterceptor.Level.NONE
                    }
                })
                .addInterceptor(object : Interceptor {
                    @Throws(IOException::class)
                    override fun intercept(chain: Interceptor.Chain): Response {
                        val originalRequest = chain.request()
                        val builder = originalRequest.newBuilder()
                            .header("api_key", "key")
                        val newRequest = builder.build()
                        return chain.proceed(newRequest)
                    }
                })
                .build()
        }

        @UnstableDefault
        private fun getRetrofitClient(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .client(getOkHttpInstance())
                .addConverterFactory(Json.nonstrict.asConverterFactory(contentType = "application/json".toMediaTypeOrNull()!!))
                .build()
        }

        @UnstableDefault
        fun getMovieService() = getRetrofitClient().create(Api::class.java)
    }
}
