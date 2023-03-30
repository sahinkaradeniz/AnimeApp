package com.example.data.dto.animes.allAnime

import com.google.gson.annotations.SerializedName

data class AllAnimeResponse (

    @SerializedName("pagination" ) var pagination : Pagination?= Pagination(),
    @SerializedName("data"       ) var data       : ArrayList<Data> ,


    )