package com.example.network.provider

import com.example.core.dto.MovieInfo
import com.example.core.dto.MoviePreview

interface NetworkProvider {

    fun requestListMoviePreviews(onDone: (List<MoviePreview>) -> Unit, onError: (Throwable) -> Unit)

    fun requestMovieInfo(id: Int, onDone: (MovieInfo) -> Unit, onError: (Throwable) -> Unit)
}
