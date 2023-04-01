package com.example.data.datastore.api

import com.example.data.dto.animes.allAnime.AllAnimeResponse
import com.example.data.dto.animes.anime.AnimeResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface AnimeApiService {

    @GET("v4/anime")
    suspend fun getAllAnime():AllAnimeResponse

    @GET("v4/anime/{mal_id}")
    suspend fun getAnime(@Path("mal_id") id :Int):AnimeResponse

}