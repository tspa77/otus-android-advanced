package com.example.a03kotlincoroutines.network

import com.example.a03kotlincoroutines.mvp.model.ListMovies
import retrofit2.http.GET

interface Api {
    companion object {
        val BASE_URL = "https://api.themoviedb.org/3/"
        val KEY = "799c270834d71ae333151ff0bb097414"
        val IMAGE_URL = "https://image.tmdb.org/t/p/w500/"
    }

    // API (v3 auth):   799c270834d71ae333151ff0bb097414
    //    https://developers.themoviedb.org/3/movies/get-popular-movies
    //    https://developers.themoviedb.org/3/movies/get-movie-details
    //    val urlScr = "https://image.tmdb.org/t/p/w500/"

    @GET("movie/popular")
    suspend fun getListPopularMovies(): ListMovies
}