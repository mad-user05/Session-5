package com.example.tv.main.model

import com.example.tv.main.model.Tags

data class ModelMovie(
    val movieId: String,
    val name: String,
    val description: String,
    val age: String,
    val images: List<String>,
    val poster: String,
    val tags: Tags
)
