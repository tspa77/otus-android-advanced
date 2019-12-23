package com.example.mvppattern.mvp.view

import com.example.mvppattern.mvp.model.MoviePreview

interface ListMoviesView : BaseLoadingView {

    fun showListMovies(listMovies: List<MoviePreview>)
}
