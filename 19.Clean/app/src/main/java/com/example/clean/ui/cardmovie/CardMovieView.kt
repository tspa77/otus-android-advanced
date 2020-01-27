package com.example.clean.ui.cardmovie

import com.example.clean.model.MovieInfo
import com.example.clean.ui.baseloading.BaseLoadingView

interface CardMovieView : BaseLoadingView {

    fun showMovieInfo(movieInfo: MovieInfo)
}
