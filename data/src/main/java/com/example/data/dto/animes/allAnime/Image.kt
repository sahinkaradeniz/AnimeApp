package com.example.data.dto.animes.allAnime

import com.google.gson.annotations.SerializedName

data class Image (
    @SerializedName("jpg"  ) var jpg  : com.example.data.dto.animes.allAnime.Jpg?  = com.example.data.dto.animes.allAnime.Jpg(),
    @SerializedName("webp" ) var webp : com.example.data.dto.animes.allAnime.Webp? = com.example.data.dto.animes.allAnime.Webp()
)