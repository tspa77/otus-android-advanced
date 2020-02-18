package com.example.clean.presentation.view

import com.example.clean.domain.dto.MovieInfo


interface CardMovieView : BaseLoadingView {

    fun showMovieInfo(movieInfo: MovieInfo)
}
