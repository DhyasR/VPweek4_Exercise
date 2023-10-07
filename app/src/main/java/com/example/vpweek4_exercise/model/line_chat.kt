package com.example.vpweek4_exercise.model

data class line_chat(
    val name: String,
    val chat: String,
    val date: String,
    var isClicked: Boolean = false
)