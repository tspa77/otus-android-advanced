package com.example.mvppattern.mvp.model.network

import com.example.mvppattern.mvp.model.MovieInfo
import com.example.mvppattern.mvp.model.MoviePreview

interface NetworkProvider {

    fun downloadListPreviews(onDone: (List<MoviePreview>) -> Unit, onError: (Throwable) -> Unit)

    fun downloadDetailsInfo(id: Int, onDone: (MovieInfo) -> Unit, onError: (Throwable) -> Unit)
}
