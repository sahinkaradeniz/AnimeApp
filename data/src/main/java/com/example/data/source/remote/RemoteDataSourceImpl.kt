package com.example.data.source.remote

import android.util.Log
import com.example.common.NetworkResponseState
import com.example.data.api.AnimeApiService
import com.example.data.dto.animes.allAnime.Data
import com.example.data.dto.animes.anime.DetailData
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor( private val animeApiService: AnimeApiService):RemoteDataSource{
    private val TAG=this::class.java.simpleName
    override suspend fun getAllAnime(): com.example.common.NetworkResponseState<List<Data>> =
        try {
          val respose=animeApiService.getAllAnime()
          com.example.common.NetworkResponseState.Success(respose.data)
        }catch (e:Exception){
            Log.e(TAG,e.toString())
            com.example.common.NetworkResponseState.Error(e)
        }

    override suspend fun getAnime(id:Int): com.example.common.NetworkResponseState<DetailData> =
        try {
            val response=animeApiService.getAnime(id)
            com.example.common.NetworkResponseState.Success(response.detailData)
        }catch (e:Exception){
            Log.e(TAG,e.toString())
            com.example.common.NetworkResponseState.Error(e)
        }
}