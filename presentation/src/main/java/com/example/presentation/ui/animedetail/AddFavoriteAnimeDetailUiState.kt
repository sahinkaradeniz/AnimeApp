package com.example.presentation.ui.animedetail

import androidx.annotation.StringRes
import com.example.domain.entity.FavoritesEntity

sealed class AddFavoriteAnimeDetailUiState {
    object Loading : AddFavoriteAnimeDetailUiState()
    data class Success(val data: FavoritesEntity) : AddFavoriteAnimeDetailUiState()
    data class Error(@StringRes val message: Int) : AddFavoriteAnimeDetailUiState()
}