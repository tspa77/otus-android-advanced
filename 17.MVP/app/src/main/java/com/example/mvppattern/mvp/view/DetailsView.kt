package com.example.mvppattern.mvp.view

import com.example.mvppattern.mvp.model.MovieDetails

interface DetailsView : LoadingView {

    fun showDetailsInfo(movieInfo: MovieDetails)
}
