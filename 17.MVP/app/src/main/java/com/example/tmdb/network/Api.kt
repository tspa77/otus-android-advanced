package com.example.tmdb.network

import com.example.tmdb.model.ListMoviePreviews
import com.example.tmdb.model.MovieDetails
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {

    @GET("movie/popular")
    suspend fun getListPopularMovies(): ListMoviePreviews

    @GET("movie/{movie_id}")
    suspend fun getMovie(@Path("movie_id") id: Int): MovieDetails
}
