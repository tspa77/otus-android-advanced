package com.example.mvppattern.model.network

import com.example.mvppattern.model.ListMoviePreviews
import com.example.mvppattern.model.MovieInfo
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {

    @GET("movie/popular")
    suspend fun getListPopularMovies(): ListMoviePreviews

    @GET("movie/{movie_id}")
    suspend fun getMovie(@Path("movie_id") id: Int): MovieInfo
}
