package com.example.presentation.di

import com.example.domain.entity.AnimeDetailEntity
import com.example.data.mapper.animelist.AnimeListMapper
import com.example.domain.entity.AnimeEntity
import com.example.data.mapper.anime.AnimeMapper
import com.example.presentation.ui.anime.AnimeUiData
import com.example.presentation.ui.anime.AnimeUiMapper
import com.example.presentation.ui.animedetail.AnimeDetailUiData
import com.example.presentation.ui.animedetail.AnimeDetailUiMapper
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class UiMapperModule {

    @Binds
    @ViewModelScoped
    abstract fun animeUiMapper(animeUiMapper: AnimeUiMapper): AnimeListMapper<AnimeEntity, AnimeUiData>

    @Binds
    @ViewModelScoped
    abstract fun animeDetailUiMapper(animeDetailUiMapper: AnimeDetailUiMapper): AnimeMapper<AnimeDetailEntity, AnimeDetailUiData>
}