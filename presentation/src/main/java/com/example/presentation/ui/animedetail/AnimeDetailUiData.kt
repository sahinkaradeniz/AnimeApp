package com.example.presentation.ui.animedetail

import com.example.data.dto.animes.allAnime.Broadcast

data class AnimeDetailUiData(
    var malId: Int? = null,
    var images: String?=null,
    var titleEnglish: String? = null,
    var score: Double? = null,
    var background: String? = null,
    var day: String? = null,
    var time: String? = null,
    var timezone: String? = null,
)