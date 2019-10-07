package com.example.a03kotlincoroutines.network

import com.example.a03kotlincoroutines.mvp.model.ListMovies
import retrofit2.http.GET

interface Api {

    //    https://developers.themoviedb.org/3/movies/get-popular-movies
    //    https://developers.themoviedb.org/3/movies/get-movie-details

    @GET("movie/popular")
    suspend fun getListPopularMovies(): ListMovies
}
