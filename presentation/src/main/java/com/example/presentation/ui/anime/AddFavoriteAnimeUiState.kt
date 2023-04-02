package com.example.presentation.ui.anime

import androidx.annotation.StringRes
import com.example.domain.entity.FavoritesEntity

sealed class AddFavoriteAnimeUiState {
    object Loading : AddFavoriteAnimeUiState()
    data class Success(val data: FavoritesEntity) : AddFavoriteAnimeUiState()
    data class Error(@StringRes val message: Int) : AddFavoriteAnimeUiState()
}