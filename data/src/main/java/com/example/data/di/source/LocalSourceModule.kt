package com.example.data.di.source

import com.example.data.source.local.LocalDataSource
import com.example.data.source.local.LocalDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class LocalSourceModule {

    @Binds
    @Singleton
    abstract fun bindLocalSource(localDataSourceImpl: LocalDataSourceImpl): LocalDataSource
}