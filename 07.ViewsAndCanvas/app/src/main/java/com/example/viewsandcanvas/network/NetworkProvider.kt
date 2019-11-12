package com.example.viewsandcanvas.network

import com.example.viewsandcanvas.model.MovieDetails
import com.example.viewsandcanvas.model.MoviePreview

interface NetworkProvider {

    fun getListPreviews(onDone: (List<MoviePreview>) -> Unit, onError: (Throwable) -> Unit)

    fun getDetailsInfo(id: Int, onDone: (MovieDetails) -> Unit, onError: (Throwable) -> Unit)
}
