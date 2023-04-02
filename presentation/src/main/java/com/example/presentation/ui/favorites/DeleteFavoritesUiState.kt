package com.example.presentation.ui.favorites

import androidx.annotation.StringRes
import com.example.domain.entity.FavoritesEntity

sealed class DeleteFavoritesUiState {
    object Loading : DeleteFavoritesUiState()
    data class Success(val data: FavoritesEntity) : DeleteFavoritesUiState()
    data class Error(@StringRes val message: Int) : DeleteFavoritesUiState()
}