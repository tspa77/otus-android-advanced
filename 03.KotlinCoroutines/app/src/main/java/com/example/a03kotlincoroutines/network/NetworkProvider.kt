package com.example.a03kotlincoroutines.network

import com.example.a03kotlincoroutines.mvp.model.MovieFullInfo
import com.example.a03kotlincoroutines.mvp.model.MoviePreview

interface NetworkProvider {
    fun getListMovies(onDone: (List<MoviePreview>) -> Unit, onError: (Throwable) -> Unit)
    fun getDetailMovie(id: Int, onDone: (MovieFullInfo) -> Unit, onError: (Throwable) -> Unit)
}