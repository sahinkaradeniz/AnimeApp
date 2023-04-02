package com.example.domain.usecase.favoriteusecase.getallfavoritesusecase

import com.example.common.NetworkResponseState
import com.example.domain.entity.FavoritesEntity
import kotlinx.coroutines.flow.Flow

interface GetAllFavoritesUseCase {
    suspend operator fun invoke(): Flow<NetworkResponseState<List<FavoritesEntity>>>
}