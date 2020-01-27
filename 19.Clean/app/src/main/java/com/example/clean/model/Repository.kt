package com.example.clean.model

interface Repository {

    fun getListMoviePreviews(onDone: (List<MoviePreview>) -> Unit, onError: (Throwable) -> Unit)

    fun getMovieInfo(id: Int, onDone: (MovieInfo) -> Unit, onError: (Throwable) -> Unit)
}