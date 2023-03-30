package com.example.domain.usecase.animeusecase.animedetailusecase

import com.example.common.NetworkResponseState
import com.example.domain.entity.AnimeDetailEntity
import kotlinx.coroutines.flow.Flow

interface GetAnimeDetailUseCase {
    suspend operator fun invoke(id:Int):Flow<NetworkResponseState<AnimeDetailEntity>>
}