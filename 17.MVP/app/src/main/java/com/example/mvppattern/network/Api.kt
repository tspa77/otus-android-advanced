package com.example.mvppattern.network

import com.example.mvppattern.data.ListMoviePreviews
import com.example.mvppattern.data.MovieDetails
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {

    @GET("movie/popular")
    suspend fun getListPopularMovies(): ListMoviePreviews

    @GET("movie/{movie_id}")
    suspend fun getMovie(@Path("movie_id") id: Int): MovieDetails
}
