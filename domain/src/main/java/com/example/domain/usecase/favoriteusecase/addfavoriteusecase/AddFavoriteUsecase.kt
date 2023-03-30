package com.example.domain.usecase.favoriteusecase.addfavoriteusecase

import com.example.domain.entity.FavoritesEntity

interface AddFavoriteUsecase {
    suspend operator fun invoke(favoritesDbModel: FavoritesEntity)
}