package com.example.clean.domain.dto

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