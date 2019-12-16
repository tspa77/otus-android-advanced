package com.example.mvppattern.mvp.model

import com.example.mvppattern.adapter.MovieDetails
import com.example.mvppattern.adapter.MoviePreview

interface Repository {

    fun getListPreviews(onDone: (List<MoviePreview>) -> Unit, onError: (Throwable) -> Unit)

    fun getDetailsInfo(id: Int, onDone: (MovieDetails) -> Unit, onError: (Throwable) -> Unit)
}