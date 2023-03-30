package com.example.data.di.source

import com.example.data.source.remote.RemoteDataSource
import com.example.data.source.remote.RemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteSourceModule {

    @Binds
    @Singleton
    abstract fun bindGetAgentsRemoteSource(remoteDataSourceImp: RemoteDataSourceImpl): RemoteDataSource
}