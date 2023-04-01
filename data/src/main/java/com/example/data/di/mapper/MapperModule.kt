package com.example.data.di.mapper

import com.example.data.dto.animes.allAnime.Data
import com.example.data.dto.animes.anime.DetailData
import com.example.data.dto.favorite.FavoritesDbModel
import com.example.data.mapper.anime.AnimeDetailMapper
import com.example.data.mapper.animelist.AnimeListMapper
import com.example.data.mapper.animelist.AnimeMainMapper
import com.example.data.mapper.anime.AnimeMapper
import com.example.data.mapper.favorite.FavoriMapperImpl
import com.example.data.mapper.favorite.FavoriteMapper
import com.example.data.mapper.favoriteList.FavoriteListMapper
import com.example.data.mapper.favoriteList.FavoriteListMapperImpl
import com.example.domain.entity.AnimeDetailEntity
import com.example.domain.entity.AnimeEntity
import com.example.domain.entity.FavoritesEntity
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class MapperModule {

    @Binds
    @Singleton
    abstract fun animeMapper(animeMainMapper: AnimeMainMapper): AnimeListMapper<Data, AnimeEntity>

    @Binds
    @Singleton
    abstract fun animeDetailMapper(animeDetailMapper: AnimeDetailMapper): AnimeMapper<DetailData, AnimeDetailEntity>

    @Binds
    @Singleton
    abstract fun favoriyesEntitytoDbMapper(favoriteMapperEntitytoDb: FavoriMapperImpl):FavoriteMapper<FavoritesEntity,FavoritesDbModel>

    @Binds
    @Singleton
    abstract fun favoritesListMapper(favoriteListMapperImpl: FavoriteListMapperImpl):FavoriteListMapper<FavoritesDbModel,FavoritesEntity>
}