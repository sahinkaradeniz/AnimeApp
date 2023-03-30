package com.example.data.di.repository

import com.example.domain.repository.AnimeRepository
import com.example.data.repository.AnimeRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton

    abstract fun bindRepository(
        animeRepositoryImpl: AnimeRepositoryImpl
    ): com.example.domain.repository.AnimeRepository
}
