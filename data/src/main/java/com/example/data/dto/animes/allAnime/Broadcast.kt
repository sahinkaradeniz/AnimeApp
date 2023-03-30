package com.example.data.dto.animes.allAnime

import com.google.gson.annotations.SerializedName

data class Broadcast (

    @SerializedName("day"      ) var day      : String? = null,
    @SerializedName("time"     ) var time     : String? = null,
    @SerializedName("timezone" ) var timezone : String? = null,
    @SerializedName("string"   ) var string   : String? = null

)