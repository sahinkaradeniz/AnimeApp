package com.example.data.dto.animes.anime
import com.google.gson.annotations.SerializedName

data class AnimeResponse (
    @SerializedName("data" ) var detailData : DetailData? =DetailData()
)