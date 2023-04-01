package com.example.data.di.room

import android.content.Context
import androidx.room.Room
import com.example.data.datastore.room.FavoritesDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ):
            AnimeDatabase = Room.databaseBuilder(
        context, AnimeDatabase::class.java,
        "favorites_db"
    ).build()


    @Provides
    fun provideProductDao(database:AnimeDatabase): FavoritesDao = database.favoritesDao()


}