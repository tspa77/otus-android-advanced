package com.example.mvppattern.model

interface Repository {

    fun getListMoviePreviews(onDone: (List<com.example.core.dto.MoviePreview>) -> Unit, onError: (Throwable) -> Unit)

    fun getMovieInfo(id: Int, onDone: (com.example.core.dto.MovieInfo) -> Unit, onError: (Throwable) -> Unit)
}