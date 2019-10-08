package com.example.a03kotlincoroutines.mvp.model

import kotlinx.serialization.Serializable

@Serializable
data class MoviePreview(
    val poster_path: String,
    val release_date: String,
    val id: Int,
    val title: String,
    val popularity: String
)

@Serializable
data class MovieFullInfo(
    val poster_path: String,
    val overview: String,
    val release_date: String,
    val id: Int,
    val title: String,
    val popularity: String,
    val vote_average: Double
)

@Serializable
data class ListMoviePreviews(
    val results: List<MoviePreview>
)