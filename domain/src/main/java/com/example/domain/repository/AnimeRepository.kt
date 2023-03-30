package com.example.domain.repository

import com.example.common.NetworkResponseState

import com.example.domain.entity.AnimeDetailEntity
import com.example.domain.entity.AnimeEntity
import com.example.domain.entity.FavoritesEntity
import kotlinx.coroutines.flow.Flow

interface AnimeRepository {
    suspend fun getAllAnime(): Flow<NetworkResponseState<List<AnimeEntity>>>

    suspend fun getAnime(id: Int): Flow<NetworkResponseState<AnimeDetailEntity>>

    suspend fun getAllFavorites(): Flow<List<FavoritesEntity>>

    suspend fun deleteFavorite(favoritesDbModel:FavoritesEntity)

    suspend fun addFavorites(favoritesDbModel:FavoritesEntity)

}