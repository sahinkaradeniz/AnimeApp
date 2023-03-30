package com.example.data.dto.animes.allAnime

import com.google.gson.annotations.SerializedName

data class Aired (

    @SerializedName("from"   ) var from   : String? = null,
    @SerializedName("to"     ) var to     : String? = null,
    @SerializedName("prop"   ) var prop   : com.example.data.dto.animes.allAnime.Prop?   = com.example.data.dto.animes.allAnime.Prop(),
    @SerializedName("string" ) var string : String? = null

)