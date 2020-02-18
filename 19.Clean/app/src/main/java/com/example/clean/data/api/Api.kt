package com.example.clean.data.api

import com.example.clean.domain.dto.ListMoviePreviews
import com.example.clean.domain.dto.MovieInfo
import retrofit2.http.GET
import retrofit2.http.Path


interface Api {

    @GET("movie/popular")
    suspend fun getListPopularMovies(): ListMoviePreviews

    @GET("movie/{movie_id}")
    suspend fun getMovie(@Path("movie_id") id: Int): MovieInfo
}
