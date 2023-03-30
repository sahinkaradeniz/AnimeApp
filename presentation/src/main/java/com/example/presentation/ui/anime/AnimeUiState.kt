package com.example.presentation.ui.anime

import androidx.annotation.StringRes

sealed class AnimeUiState {
    object Loading : AnimeUiState()
    data class Success(val data: List<AnimeUiData>) : AnimeUiState()
    data class Error(@StringRes val message: Int) : AnimeUiState()
}