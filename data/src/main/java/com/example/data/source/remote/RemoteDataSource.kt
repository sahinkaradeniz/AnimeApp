package com.example.data.source.remote

import com.example.common.NetworkResponseState
import com.example.data.dto.animes.allAnime.Data
import com.example.data.dto.animes.anime.DetailData

interface RemoteDataSource {

   suspend fun getAllAnime(): com.example.common.NetworkResponseState<List<Data>>

   suspend fun getAnime(id:Int): com.example.common.NetworkResponseState<DetailData>
}