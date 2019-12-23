package com.example.mvppattern.mvp.view

import com.example.mvppattern.mvp.model.MovieInfo

interface CardMovieView : BaseLoadingView {

    fun showMovieInfo(movieInfo: MovieInfo)
}
