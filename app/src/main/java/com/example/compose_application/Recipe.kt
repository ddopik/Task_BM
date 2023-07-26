package com.example.compose_application


import androidx.annotation.DrawableRes

data class Recipe(
    @DrawableRes val imageResource: Int,
    val title: String,
    val ingredients: List<String>
)
