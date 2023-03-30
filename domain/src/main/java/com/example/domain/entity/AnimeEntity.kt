package com.example.domain.entity



data class AnimeEntity(
    var malId: Int,
    var images: String?=null,
    var titleEnglish: String,
    var rating: String,
    var score: Double,
    var rank: Int,
    var popularity: Int,
    var year: Int,
)