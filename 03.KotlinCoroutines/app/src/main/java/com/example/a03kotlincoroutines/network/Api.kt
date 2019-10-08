package com.example.a03kotlincoroutines.network

import com.example.a03kotlincoroutines.mvp.model.ListMoviePreviews
import com.example.a03kotlincoroutines.mvp.model.MovieDetails
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {

    @GET("movie/popular")
    suspend fun getListPopularMovies(): ListMoviePreviews

    @GET("movie/{movie_id}")
    suspend fun getMovie(@Path("movie_id") id: Int): MovieDetails
}
