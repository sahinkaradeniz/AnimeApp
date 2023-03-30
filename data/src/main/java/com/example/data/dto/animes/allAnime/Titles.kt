package com.example.data.dto.animes.allAnime

import com.google.gson.annotations.SerializedName

data class Titles (

    @SerializedName("type"  ) var type  : String? = null,
    @SerializedName("title" ) var title : String? = null

)