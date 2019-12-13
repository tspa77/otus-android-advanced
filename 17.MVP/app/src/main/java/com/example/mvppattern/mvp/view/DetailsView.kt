package com.example.mvppattern.mvp.view

import com.example.mvppattern.data.MovieDetails

interface DetailsView {
    fun showDetailsInfo(movieInfo: MovieDetails)
}
