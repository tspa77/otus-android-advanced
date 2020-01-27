package com.example.clean.model.network

import com.example.clean.model.MovieInfo
import com.example.clean.model.MoviePreview

interface NetworkProvider {

    fun requestListMoviePreviews(onDone: (List<MoviePreview>) -> Unit, onError: (Throwable) -> Unit)

    fun requestMovieInfo(id: Int, onDone: (MovieInfo) -> Unit, onError: (Throwable) -> Unit)
}
