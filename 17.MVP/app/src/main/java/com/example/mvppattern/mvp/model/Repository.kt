package com.example.mvppattern.mvp.model

interface Repository {

    fun getListPreviews(onDone: (List<MoviePreview>) -> Unit, onError: (Throwable) -> Unit)

    fun getDetailsInfo(id: Int, onDone: (MovieDetails) -> Unit, onError: (Throwable) -> Unit)
}