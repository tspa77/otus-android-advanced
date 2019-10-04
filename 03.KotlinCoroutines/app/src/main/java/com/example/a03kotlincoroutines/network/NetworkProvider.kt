package com.example.a03kotlincoroutines.network

import com.example.a03kotlincoroutines.mvp.model.Movie

interface NetworkProvider {
    fun getListMovies(onDone: (List<Movie>) -> Unit, onError: (Throwable) -> Unit)
    fun getDetailMovie(tag: String, onDone: (Movie) -> Unit, onError: (Throwable) -> Unit)
}