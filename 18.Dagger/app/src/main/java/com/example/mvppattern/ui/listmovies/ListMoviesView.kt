package com.example.mvppattern.ui.listmovies

import com.example.mvppattern.model.MoviePreview
import com.example.mvppattern.ui.baseloading.BaseLoadingView

interface ListMoviesView :
    BaseLoadingView {

    fun showListMoviePreviews(listMovies: List<MoviePreview>)
}
