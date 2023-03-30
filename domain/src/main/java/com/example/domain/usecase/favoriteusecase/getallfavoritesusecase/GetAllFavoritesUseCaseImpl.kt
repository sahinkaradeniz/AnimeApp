package com.example.domain.usecase.favoriteusecase.getallfavoritesusecase

import com.example.domain.entity.FavoritesEntity
import com.example.domain.repository.AnimeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllFavoritesUseCaseImpl @Inject constructor(
    private val repository: AnimeRepository
):GetAllFavoritesUseCase {
    override suspend fun invoke(): Flow<List<FavoritesEntity>> = repository.getAllFavorites()
}