package com.example.presentation.ui.animedetail

import androidx.annotation.StringRes
import com.example.presentation.ui.anime.AnimeUiData

sealed class AnimeDetailUiState {
    object Loading : AnimeDetailUiState()
    data class Success(val data: AnimeDetailUiData) : AnimeDetailUiState()
    data class Error(@StringRes val message: Int) : AnimeDetailUiState()
}