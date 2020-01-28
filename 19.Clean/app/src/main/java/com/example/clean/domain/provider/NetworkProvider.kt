package com.example.clean.domain.provider

import com.example.clean.domain.dto.MovieInfo
import com.example.clean.domain.dto.MoviePreview


interface NetworkProvider {

    fun requestListMoviePreviews(onDone: (List<MoviePreview>) -> Unit, onError: (Throwable) -> Unit)

    fun requestMovieInfo(id: Int, onDone: (MovieInfo) -> Unit, onError: (Throwable) -> Unit)
}
