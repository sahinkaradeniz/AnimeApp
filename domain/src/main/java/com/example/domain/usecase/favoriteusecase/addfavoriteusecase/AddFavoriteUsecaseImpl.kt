package com.example.domain.usecase.favoriteusecase.addfavoriteusecase

import com.example.domain.entity.FavoritesEntity
import com.example.domain.repository.AnimeRepository
import javax.inject.Inject

class AddFavoriteUsecaseImpl @Inject constructor(
    private val repository: AnimeRepository
):AddFavoriteUsecase{
    override suspend fun invoke(favoritesDbModel:FavoritesEntity) = repository.addFavorites(favoritesDbModel)
}