package com.example.domain.usecase.animeusecase.animeusecase


import com.example.common.NetworkResponseState
import com.example.domain.entity.AnimeEntity
import com.example.domain.repository.AnimeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAnimeUseCaseImpl @Inject constructor(
 private val   animeRepository: AnimeRepository
):GetAnimeUseCase {
    override suspend fun invoke(): Flow<NetworkResponseState<List<AnimeEntity>>> =
        animeRepository.getAllAnime()
}