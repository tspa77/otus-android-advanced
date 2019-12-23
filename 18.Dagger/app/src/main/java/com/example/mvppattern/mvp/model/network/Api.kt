package com.example.mvppattern.mvp.model.network

import com.example.mvppattern.mvp.model.ListMoviePreviews
import com.example.mvppattern.mvp.model.MovieInfo
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {

    @GET("movie/popular")
    suspend fun getListPopularMovies(): ListMoviePreviews

    @GET("movie/{movie_id}")
    suspend fun getMovie(@Path("movie_id") id: Int): MovieInfo
}
