package com.example.clean.ui.listmovies

import com.example.clean.model.MoviePreview
import com.example.clean.ui.baseloading.BaseLoadingView

interface ListMoviesView :
    BaseLoadingView {

    fun showListMoviePreviews(listMovies: List<MoviePreview>)
}
