package com.example.domain.usecase.favoriteusecase.deletefavoriteusecase

import com.example.common.NetworkResponseState
import com.example.domain.entity.FavoritesEntity
import kotlinx.coroutines.flow.Flow


interface DeleteFavoriteUseCase {
    suspend operator fun invoke(favoritesDbModel: FavoritesEntity):Flow<NetworkResponseState<FavoritesEntity>>
}