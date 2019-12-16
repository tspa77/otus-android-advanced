package com.example.mvppattern.mvp.view

import com.example.mvppattern.adapter.MovieDetails

interface DetailsView : LoadingView {

    fun showDetailsInfo(movieInfo: MovieDetails)
}
