package com.example.data.source.local

import com.example.data.datastore.room.FavoritesDao
import com.example.data.dto.favorite.FavoritesDbModel
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor( private val favoritesDao: FavoritesDao) : LocalDataSource {
    override suspend fun getAllFavorites(): List<FavoritesDbModel> =
        favoritesDao.gelAllFavorites()

    override suspend fun getFavoritesWithId(id: Int): FavoritesDbModel =
        favoritesDao.getFavoriteWithId(id)

    override suspend fun deleteFavorite(favoritesDbModel: FavoritesDbModel) =
        favoritesDao.deleteAnime(favoritesDbModel)


    override suspend fun addFavorite(favoritesDbModel: FavoritesDbModel) =
        favoritesDao.addAnime(favoritesDbModel)

}