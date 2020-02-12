package com.example.mvppattern.ui.listmovies

import com.example.core.dto.MoviePreview
import com.example.mvppattern.ui.baseloading.BaseLoadingView

interface ListMoviesView :
    BaseLoadingView {

    fun showListMoviePreviews(listMovies: List<com.example.core.dto.MoviePreview>)
}
