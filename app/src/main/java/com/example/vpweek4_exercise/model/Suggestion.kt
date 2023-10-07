package com.example.vpweek4_exercise.model

data class Suggestion(
    val username: String,
    val profilePicture: String,
    var isFollowing: Boolean,
    var isFollowers: Boolean
)