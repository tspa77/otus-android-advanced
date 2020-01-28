package com.example.clean.domain.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class MovieInfo(
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