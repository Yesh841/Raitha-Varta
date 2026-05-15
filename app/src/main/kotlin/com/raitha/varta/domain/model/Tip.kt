package com.raitha.varta.domain.model

data class Tip(
    val id: String,
    val cropId: String,
    val title: String,
    val description: String,
    val imageUrl: String,
    val language: String
)

data class Crop(
    val id: String,
    val name: String,
    val icon: String
)
