package com.example.data.dto.animes.allAnime

import com.google.gson.annotations.SerializedName

data class Jpg (

    @SerializedName("image_url"       ) var imageUrl      : String? = null,
    @SerializedName("small_image_url" ) var smallImageUrl : String? = null,
    @SerializedName("large_image_url" ) var largeImageUrl : String? = null

)