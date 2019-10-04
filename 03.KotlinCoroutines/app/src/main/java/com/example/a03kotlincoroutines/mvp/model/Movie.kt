package com.example.a03kotlincoroutines.mvp.model

import kotlinx.serialization.Serializable

@Serializable
data class Movie(
    val poster_path: String,
    val overview: String,
    val release_date: String,
    val id: Int,
    val title: String,
    val popularity: String
)

@Serializable
data class ListMovies(
    val results: List<Movie>
)