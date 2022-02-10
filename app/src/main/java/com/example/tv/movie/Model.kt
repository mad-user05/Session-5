package com.example.tv.movie

data class Model(
    val episodeId: String,
    val name: String,
    val description: String,
    val director: String,
    val stars: List<String>,
    val year: String,
    val images: List<String>,
    val runtime: String,
    val preview: String,
    val moviesId: String
)
