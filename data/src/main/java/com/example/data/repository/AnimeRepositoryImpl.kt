package com.example.data.repository

import android.util.Log
import com.example.common.NetworkResponseState
import com.example.data.di.coroutine.IoDispatcher
import com.example.data.dto.animes.allAnime.Data
import com.example.data.dto.animes.anime.DetailData
import com.example.data.dto.favorite.FavoritesDbModel
import com.example.data.mapper.animelist.AnimeListMapper
import com.example.data.mapper.anime.AnimeMapper
import com.example.data.mapper.favorite.FavoriteMapper
import com.example.data.mapper.favoriteList.FavoriteListMapper
import com.example.data.source.local.LocalDataSource
import com.example.data.source.remote.RemoteDataSource
import com.example.domain.entity.AnimeDetailEntity
import com.example.domain.entity.AnimeEntity
import com.example.domain.entity.FavoritesEntity
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class AnimeRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val animeMainMapper: AnimeListMapper<Data, AnimeEntity>,
    private val animeDetailMapper: AnimeMapper<DetailData, AnimeDetailEntity>,
    private val favoriteEntitytoDb: FavoriteMapper<FavoritesEntity, FavoritesDbModel>,
    private val favoriteListMapper: FavoriteListMapper<FavoritesDbModel, FavoritesEntity>,
    @IoDispatcher
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO,
) : com.example.domain.repository.AnimeRepository {
    private val TAG=this.javaClass.simpleName
    override suspend fun getAllAnime(): Flow<NetworkResponseState<List<AnimeEntity>>> {
        return flow {
            emit(NetworkResponseState.Loading)
            when (val response = remoteDataSource.getAllAnime()) {
                is NetworkResponseState.Loading -> {
                    emit(NetworkResponseState.Loading)
                }
                is NetworkResponseState.Success -> {
                    emit(NetworkResponseState.Success(animeMainMapper.map(response.result)))
                }
                is NetworkResponseState.Error -> {
                    Log.e(TAG,response.exception.toString())
                    emit(NetworkResponseState.Error(response.exception))
                }
            }
        }.flowOn(ioDispatcher)
    }

    override suspend fun getAnime(id: Int): Flow<NetworkResponseState<AnimeDetailEntity>> {
        return flow {
            emit(NetworkResponseState.Loading)
            when (val response = remoteDataSource.getAnime(id)) {
                is NetworkResponseState.Error -> {
                    emit(NetworkResponseState.Error(response.exception))
                    Log.e(TAG,response.exception.toString())
                }
                is NetworkResponseState.Success -> {
                    emit(NetworkResponseState.Success(animeDetailMapper.map(response.result)))
                }
                is NetworkResponseState.Loading -> {
                    emit(NetworkResponseState.Loading)
                }
            }
        }.flowOn(ioDispatcher)
    }

    override suspend fun getAllFavorites(): Flow<NetworkResponseState<List<FavoritesEntity>>> {
        return flow {
            emit(NetworkResponseState.Loading)
            when (val response = localDataSource.getAllFavorites()) {
                is NetworkResponseState.Error -> {
                    emit(NetworkResponseState.Error(response.exception))
                    Log.e(TAG,response.exception.toString())
                }
                is NetworkResponseState.Success -> {
                    emit(NetworkResponseState.Success(favoriteListMapper.map(response.result)))
                }
                is NetworkResponseState.Loading -> {
                    emit(NetworkResponseState.Loading)
                }
            }
        }.flowOn(ioDispatcher)
    }

    override suspend fun deleteFavorite(favoritesDbModel: FavoritesEntity): Flow<NetworkResponseState<FavoritesEntity>> {
        return flow {
            emit(NetworkResponseState.Loading)
            when (val response =
                localDataSource.deleteFavorite(favoriteEntitytoDb.map(favoritesDbModel))) {
                is NetworkResponseState.Loading -> {
                    emit(NetworkResponseState.Loading)
                }
                is NetworkResponseState.Success -> {
                    emit(NetworkResponseState.Success(favoritesDbModel))
                }
                is NetworkResponseState.Error -> {
                    Log.e(TAG,response.exception.toString())
                    emit(NetworkResponseState.Error(response.exception))
                }
            }
        }.flowOn(ioDispatcher)
    }

    override suspend fun addFavorites(favoritesDbModel: FavoritesEntity): Flow<NetworkResponseState<FavoritesEntity>> {
        return flow {
            emit(NetworkResponseState.Loading)
            when (val response =
                localDataSource.addFavorite(favoriteEntitytoDb.map(favoritesDbModel))) {
                is NetworkResponseState.Loading -> {
                    emit(NetworkResponseState.Loading)
                }
                is NetworkResponseState.Success -> {
                    emit(NetworkResponseState.Success(favoritesDbModel))
                }
                is NetworkResponseState.Error -> {
                    Log.e(TAG,response.exception.toString())
                    emit(NetworkResponseState.Error(response.exception))
                }
            }
        }.flowOn(ioDispatcher)

    }


}