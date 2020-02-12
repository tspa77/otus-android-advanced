package com.example.mvppattern.ui.cardmovie

import com.example.core.dto.MovieInfo
import com.example.mvppattern.ui.baseloading.BaseLoadingView

interface CardMovieView : BaseLoadingView {

    fun showMovieInfo(movieInfo: com.example.core.dto.MovieInfo)
}
