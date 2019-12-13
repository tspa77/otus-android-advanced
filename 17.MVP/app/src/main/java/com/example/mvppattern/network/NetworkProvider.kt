package com.example.mvppattern.network

import com.example.mvppattern.model.MovieDetails
import com.example.mvppattern.model.MoviePreview

interface NetworkProvider {

    fun getListPreviews(onDone: (List<MoviePreview>) -> Unit, onError: (Throwable) -> Unit)

    fun getDetailsInfo(id: Int, onDone: (MovieDetails) -> Unit, onError: (Throwable) -> Unit)
}
