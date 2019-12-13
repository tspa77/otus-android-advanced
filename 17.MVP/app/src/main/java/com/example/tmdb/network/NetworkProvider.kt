package com.example.tmdb.network

import com.example.tmdb.model.MovieDetails
import com.example.tmdb.model.MoviePreview

interface NetworkProvider {

    fun getListPreviews(onDone: (List<MoviePreview>) -> Unit, onError: (Throwable) -> Unit)

    fun getDetailsInfo(id: Int, onDone: (MovieDetails) -> Unit, onError: (Throwable) -> Unit)
}
