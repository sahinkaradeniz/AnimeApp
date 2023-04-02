package com.example.data.source.local

import com.example.common.NetworkResponseState
import com.example.data.datastore.room.FavoritesDao
import com.example.data.dto.favorite.FavoritesDbModel
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor( private val favoritesDao: FavoritesDao) : LocalDataSource {
    override suspend fun getAllFavorites():NetworkResponseState<List<FavoritesDbModel>> {
        return try {
            NetworkResponseState.Success(favoritesDao.gelAllFavorites())
        }catch (e:Exception){
            NetworkResponseState.Error(e)
        }
    }


    override suspend fun getFavoritesWithId(id: Int):NetworkResponseState< FavoritesDbModel> {
        return try {
            NetworkResponseState.Success(favoritesDao.getFavoriteWithId(id))
        }catch (e:Exception){
            NetworkResponseState.Error(e)
        }
    }


    override suspend fun deleteFavorite(favoritesDbModel: FavoritesDbModel):NetworkResponseState<FavoritesDbModel> {
        return   try {
            favoritesDao.deleteAnime(favoritesDbModel)
            NetworkResponseState.Success(favoritesDbModel)
        }catch (e:Exception){
            NetworkResponseState.Error(e)
        }
    }


    override suspend fun addFavorite(favoritesDbModel: FavoritesDbModel) :NetworkResponseState<FavoritesDbModel>{
        return try {
            favoritesDao.addAnime(favoritesDbModel)
            NetworkResponseState.Success(favoritesDbModel)
        }catch (e:Exception){
            NetworkResponseState.Error(e)
        }
    }

}