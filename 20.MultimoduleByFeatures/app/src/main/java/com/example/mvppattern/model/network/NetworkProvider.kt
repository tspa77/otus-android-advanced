package com.example.mvppattern.model.network

import com.example.core.dto.MovieInfo
import com.example.core.dto.MoviePreview

interface NetworkProvider {

    fun requestListMoviePreviews(onDone: (List<com.example.core.dto.MoviePreview>) -> Unit, onError: (Throwable) -> Unit)

    fun requestMovieInfo(id: Int, onDone: (com.example.core.dto.MovieInfo) -> Unit, onError: (Throwable) -> Unit)
}
