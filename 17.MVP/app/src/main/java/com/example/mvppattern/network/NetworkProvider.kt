package com.example.mvppattern.network

import com.example.mvppattern.data.MovieDetails
import com.example.mvppattern.data.MoviePreview

interface NetworkProvider {

    fun downloadListPreviews(onDone: (List<MoviePreview>) -> Unit, onError: (Throwable) -> Unit)

    fun downloadDetailsInfo(id: Int, onDone: (MovieDetails) -> Unit, onError: (Throwable) -> Unit)
}
