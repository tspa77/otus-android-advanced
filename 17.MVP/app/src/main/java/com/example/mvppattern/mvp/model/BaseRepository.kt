package com.example.mvppattern.mvp.model

import com.example.mvppattern.data.MovieDetails
import com.example.mvppattern.data.MoviePreview

interface BaseRepository {

    fun getListPreviews(onDone: (List<MoviePreview>) -> Unit, onError: (Throwable) -> Unit)

    fun getDetailsInfo(id: Int, onDone: (MovieDetails) -> Unit, onError: (Throwable) -> Unit)
}