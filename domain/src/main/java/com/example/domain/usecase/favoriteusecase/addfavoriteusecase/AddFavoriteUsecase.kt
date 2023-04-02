package com.example.domain.usecase.favoriteusecase.addfavoriteusecase

import com.example.common.NetworkResponseState
import com.example.domain.entity.FavoritesEntity
import kotlinx.coroutines.flow.Flow

interface AddFavoriteUsecase {
    suspend operator fun invoke(favoritesDbModel: FavoritesEntity): Flow<NetworkResponseState<FavoritesEntity>>
}