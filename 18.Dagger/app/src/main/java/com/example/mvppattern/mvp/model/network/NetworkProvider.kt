package com.example.mvppattern.mvp.model.network

import com.example.mvppattern.mvp.model.MovieInfo
import com.example.mvppattern.mvp.model.MoviePreview

interface NetworkProvider {

    fun requestListMoviePreviews(onDone: (List<MoviePreview>) -> Unit, onError: (Throwable) -> Unit)

    fun requestMovieInfo(id: Int, onDone: (MovieInfo) -> Unit, onError: (Throwable) -> Unit)
}
