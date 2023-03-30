package com.example.domain.usecase.favoriteusecase.deletefavoriteusecase

import com.example.domain.entity.FavoritesEntity
import com.example.domain.repository.AnimeRepository
import javax.inject.Inject

class DeleteFavoriteUseCaseImpl @Inject constructor(
   private val repository: AnimeRepository
):DeleteFavoriteUseCase{
   override suspend fun invoke(favoritesDbModel:FavoritesEntity)= repository.deleteFavorite(favoritesDbModel)
}