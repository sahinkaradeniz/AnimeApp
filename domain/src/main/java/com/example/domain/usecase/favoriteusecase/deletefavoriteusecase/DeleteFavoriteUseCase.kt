package com.example.domain.usecase.favoriteusecase.deletefavoriteusecase

import com.example.domain.entity.FavoritesEntity


interface DeleteFavoriteUseCase {
    suspend operator fun invoke(favoritesDbModel: FavoritesEntity)
}