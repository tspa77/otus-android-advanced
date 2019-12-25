package com.example.mvppattern.model.network

import com.example.mvppattern.model.MovieInfo
import com.example.mvppattern.model.MoviePreview

interface NetworkProvider {

    fun requestListMoviePreviews(onDone: (List<MoviePreview>) -> Unit, onError: (Throwable) -> Unit)

    fun requestMovieInfo(id: Int, onDone: (MovieInfo) -> Unit, onError: (Throwable) -> Unit)
}
