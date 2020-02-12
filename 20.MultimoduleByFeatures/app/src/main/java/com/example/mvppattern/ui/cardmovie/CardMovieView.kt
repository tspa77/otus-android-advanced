package com.example.mvppattern.ui.cardmovie

import com.example.mvppattern.model.MovieInfo
import com.example.mvppattern.ui.baseloading.BaseLoadingView

interface CardMovieView : BaseLoadingView {

    fun showMovieInfo(movieInfo: MovieInfo)
}
