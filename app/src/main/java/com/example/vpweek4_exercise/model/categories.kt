package com.example.vpweek4_exercise.model

import androidx.annotation.DrawableRes

data class categories(
    @DrawableRes val image_path: Int,
    val category_name: String,
    val number_of_items: Int
)