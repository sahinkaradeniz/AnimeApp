package com.example.data.source.local

import com.example.common.NetworkResponseState
import com.example.data.dto.favorite.FavoritesDbModel
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {

    suspend fun getAllFavorites(): NetworkResponseState<List<FavoritesDbModel>>

    suspend fun getFavoritesWithId(id: Int): NetworkResponseState<FavoritesDbModel>

    suspend fun deleteFavorite(favoritesDbModel: FavoritesDbModel):NetworkResponseState<FavoritesDbModel>

    suspend fun addFavorite(favoritesDbModel: FavoritesDbModel):NetworkResponseState<FavoritesDbModel>

}