package com.example.data.source.local

import com.example.data.dao.FavoritesDao
import com.example.data.dto.favorite.FavoritesDbModel
import kotlinx.coroutines.flow.Flow
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