package com.example.clean.domain.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class ListMoviePreviews(
    @SerialName("results")
    val results: List<MoviePreview>
)