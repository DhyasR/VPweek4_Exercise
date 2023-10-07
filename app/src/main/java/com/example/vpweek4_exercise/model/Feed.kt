package com.example.vpweek4_exercise.model

data class Feed(
    val username:String,
    val profilePicture: String,
    val feedContent: String,
    var isLike: Boolean,
    var isSaved: Boolean,
    val like: Int,
    val caption: String,
    val date: String
)