package com.example.viewsandcanvas.network

import com.example.viewsandcanvas.model.ListMoviePreviews
import com.example.viewsandcanvas.model.MovieDetails
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {

    @GET("movie/popular")
    suspend fun getListPopularMovies(): ListMoviePreviews

    @GET("movie/{movie_id}")
    suspend fun getMovie(@Path("movie_id") id: Int): MovieDetails
}
