package com.example.data.source.local

import com.example.data.dto.favorite.FavoritesDbModel
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {

    suspend fun getAllFavorites(): List<FavoritesDbModel>

    suspend fun getFavoritesWithId(id: Int): FavoritesDbModel

    suspend fun deleteFavorite(favoritesDbModel: FavoritesDbModel)

    suspend fun addFavorite(favoritesDbModel: FavoritesDbModel)

}