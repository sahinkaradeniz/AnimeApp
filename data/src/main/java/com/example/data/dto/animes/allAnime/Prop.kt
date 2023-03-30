package com.example.data.dto.animes.allAnime

import com.google.gson.annotations.SerializedName

data class Prop (
    @SerializedName("from" ) var from : com.example.data.dto.animes.allAnime.From? = com.example.data.dto.animes.allAnime.From(),
    @SerializedName("to"   ) var to   : com.example.data.dto.animes.allAnime.To?   = com.example.data.dto.animes.allAnime.To()
)