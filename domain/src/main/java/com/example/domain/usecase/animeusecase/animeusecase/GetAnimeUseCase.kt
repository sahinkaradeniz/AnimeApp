package com.example.domain.usecase.animeusecase.animeusecase


import com.example.common.NetworkResponseState
import com.example.domain.entity.AnimeEntity
import kotlinx.coroutines.flow.Flow

interface GetAnimeUseCase {
    suspend operator fun invoke():Flow<NetworkResponseState<List<AnimeEntity>>>
}