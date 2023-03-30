package com.example.presentation.ui.anime

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.NetworkResponseState
import com.example.data.dto.favorite.FavoritesDbModel
import com.example.data.mapper.animelist.AnimeListMapper
import com.example.domain.entity.AnimeEntity
import com.example.domain.entity.FavoritesEntity
import com.example.domain.usecase.animeusecase.animeusecase.GetAnimeUseCase
import com.example.domain.usecase.favoriteusecase.addfavoriteusecase.AddFavoriteUsecase
import com.example.presentation.R
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnimeViewModel @Inject constructor(
    private val getAnimeUseCase: GetAnimeUseCase,
    private val animeUiMapper: AnimeListMapper<AnimeEntity, AnimeUiData>,
    private val addFavoriteUsecase: AddFavoriteUsecase,
) : ViewModel() {
    private val _animeUiState = MutableLiveData<AnimeUiState>()
    val animeUiState: LiveData<AnimeUiState> get() = _animeUiState

    fun getAllAnime() {
        viewModelScope.launch {
            getAnimeUseCase.invoke().collect {
                when (it) {
                    is NetworkResponseState.Loading -> {
                        _animeUiState.postValue(AnimeUiState.Loading)
                    }
                    is NetworkResponseState.Error -> {
                        _animeUiState.postValue(AnimeUiState.Error(R.string.eror))
                    }
                    is NetworkResponseState.Success -> {
                        _animeUiState.postValue(AnimeUiState.Success(animeUiMapper.map(it.result)))
                    }
                }
            }
        }
    }

    fun addFavoriteAnime(favoritesEntity: FavoritesEntity) {
        viewModelScope.launch {
            addFavoriteUsecase.invoke(favoritesEntity)
        }
    }
}