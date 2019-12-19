package com.example.mvppattern.mvp.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MoviePreview(
    @SerialName("poster_path")
    val posterPath: String,
    @SerialName("release_date")
    val releaseDate: String,
    @SerialName("id")
    val id: Int,
    @SerialName("title")
    val title: String,
    @SerialName("popularity")
    val popularity: String
)

@Serializable
data class MovieDetails(
    @SerialName("poster_path")
    val posterPath: String,
    @SerialName("overview")
    val overview: String,
    @SerialName("release_date")
    val releaseDate: String,
    val id: Int,
    @SerialName("title")
    val title: String,
    @SerialName("popularity")
    val popularity: String,
    @SerialName("vote_average")
    val voteAverage: Double
)

@Serializable
data class ListMoviePreviews(
    @SerialName("results")
    val results: List<MoviePreview>
)