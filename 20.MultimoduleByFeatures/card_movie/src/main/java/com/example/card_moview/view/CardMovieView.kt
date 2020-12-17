package com.example.card_moview.view

import com.example.main.view.BaseLoadingView

interface CardMovieView : BaseLoadingView {

    fun showMovieInfo(movieInfo: com.example.core.dto.MovieInfo)
}
