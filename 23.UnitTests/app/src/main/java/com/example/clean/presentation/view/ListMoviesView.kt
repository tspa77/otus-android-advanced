package com.example.clean.presentation.view

import com.example.clean.domain.dto.MoviePreview


interface ListMoviesView : BaseLoadingView {

    fun showListMoviePreviews(listMovies: List<MoviePreview>)
}
