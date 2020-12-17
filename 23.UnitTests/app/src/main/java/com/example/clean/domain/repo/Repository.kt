package com.example.clean.domain.repo

import com.example.clean.domain.dto.MovieInfo
import com.example.clean.domain.dto.MoviePreview


interface Repository {

    fun getListMoviePreviews(onDone: (List<MoviePreview>) -> Unit, onError: (Throwable) -> Unit)

    fun getMovieInfo(id: Int, onDone: (MovieInfo) -> Unit, onError: (Throwable) -> Unit)
}