package com.example.list_movies.view

import com.example.main.view.BaseLoadingView

interface ListMoviesView :
    BaseLoadingView {

    fun showListMoviePreviews(listMovies: List<com.example.core.dto.MoviePreview>)
}
