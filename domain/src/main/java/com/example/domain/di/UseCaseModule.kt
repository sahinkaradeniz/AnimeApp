package com.example.domain.di

import com.example.domain.usecase.animeusecase.animedetailusecase.GetAnimeDetailUseCase
import com.example.domain.usecase.animeusecase.animedetailusecase.GetAnimeDetailUseCaseImpl
import com.example.domain.usecase.animeusecase.animeusecase.GetAnimeUseCase
import com.example.domain.usecase.animeusecase.animeusecase.GetAnimeUseCaseImpl
import com.example.domain.usecase.favoriteusecase.addfavoriteusecase.AddFavoriteUsecase
import com.example.domain.usecase.favoriteusecase.addfavoriteusecase.AddFavoriteUsecaseImpl
import com.example.domain.usecase.favoriteusecase.deletefavoriteusecase.DeleteFavoriteUseCase
import com.example.domain.usecase.favoriteusecase.deletefavoriteusecase.DeleteFavoriteUseCaseImpl
import com.example.domain.usecase.favoriteusecase.getallfavoritesusecase.GetAllFavoritesUseCase
import com.example.domain.usecase.favoriteusecase.getallfavoritesusecase.GetAllFavoritesUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class UseCaseModule {

    @Binds
    @ViewModelScoped
    abstract fun bindGetAnime(getAnimeUseCaseImpl: GetAnimeUseCaseImpl):GetAnimeUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindGetAnimeDetail(getAnimeDetailUseCaseImpl: GetAnimeDetailUseCaseImpl):GetAnimeDetailUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindAddFavoriteAnime(addFavoriteUsecaseImpl: AddFavoriteUsecaseImpl):AddFavoriteUsecase

    @Binds
    @ViewModelScoped
    abstract fun bindGetAllFavorites(getAllFavoritesUseCaseImpl: GetAllFavoritesUseCaseImpl):GetAllFavoritesUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindDeleteFavoriteAnime(deleteFavoriteUseCaseImpl: DeleteFavoriteUseCaseImpl):DeleteFavoriteUseCase
}