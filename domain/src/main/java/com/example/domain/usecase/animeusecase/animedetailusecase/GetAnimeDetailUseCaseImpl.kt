package com.example.domain.usecase.animeusecase.animedetailusecase

import com.example.common.NetworkResponseState
import com.example.domain.entity.AnimeDetailEntity
import com.example.domain.repository.AnimeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAnimeDetailUseCaseImpl @Inject constructor(
    private val animeRepository: AnimeRepository
):GetAnimeDetailUseCase {
    override suspend fun invoke(id:Int): Flow<NetworkResponseState<AnimeDetailEntity>> =
    animeRepository.getAnime(id)
}