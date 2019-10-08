package com.example.a03kotlincoroutines.network

import com.example.a03kotlincoroutines.mvp.model.MovieDetails
import com.example.a03kotlincoroutines.mvp.model.MoviePreview

interface NetworkProvider {

    fun getListPreviews(onDone: (List<MoviePreview>) -> Unit, onError: (Throwable) -> Unit)

    fun getDetailsInfo(id: Int, onDone: (MovieDetails) -> Unit, onError: (Throwable) -> Unit)
}
