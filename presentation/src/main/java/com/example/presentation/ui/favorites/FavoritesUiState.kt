package com.example.presentation.ui.favorites

import androidx.annotation.StringRes
import com.example.domain.entity.FavoritesEntity


sealed class FavoritesUiState {
    object Loading : FavoritesUiState()
    data class Success(val data: List<FavoritesEntity>) : FavoritesUiState()
    data class Error(@StringRes val message: Int) : FavoritesUiState()
}