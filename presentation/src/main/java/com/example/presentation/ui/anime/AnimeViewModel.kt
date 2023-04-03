package com.example.presentation.ui.anime

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.NetworkResponseState
import com.example.data.mapper.animelist.AnimeListMapper
import com.example.domain.entity.AnimeEntity
import com.example.domain.entity.FavoritesEntity
import com.example.domain.usecase.animeusecase.animeusecase.GetAnimeUseCase
import com.example.domain.usecase.favoriteusecase.addfavoriteusecase.AddFavoriteUsecase
import com.example.domain.usecase.favoriteusecase.getallfavoritesusecase.GetAllFavoritesUseCase
import com.example.presentation.R
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.zip
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnimeViewModel @Inject constructor(
    private val getAnimeUseCase: GetAnimeUseCase,
    private val animeUiMapper: AnimeListMapper<AnimeEntity, AnimeUiData>,
    private val addFavoriteUsecase: AddFavoriteUsecase,
    private val getAllFavoritesUseCase: GetAllFavoritesUseCase,
) : ViewModel() {
    private val _animeUiState = MutableLiveData<AnimeUiState>()
    val animeUiState: LiveData<AnimeUiState> get() = _animeUiState

    private val _addFavoriteState = MutableLiveData<AddFavoriteAnimeUiState>()
    val addFavoriteState: LiveData<AddFavoriteAnimeUiState> get() = _addFavoriteState

    var animeList = listOf<AnimeUiData>()
    private var favoriteAnimeList = listOf<FavoritesEntity>()
  /*  fun getAllAnime() {
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
                        animeList = animeUiMapper.map(it.result)
                        _animeUiState.postValue(AnimeUiState.Success(animeList))
                    }
                }
            }
        }
    } */

    fun getAllAnime() {
        viewModelScope.launch {
            getAnimeUseCase.invoke()
                .zip(getAllFavoritesUseCase.invoke()) { animeEntity, favoritesEntity ->
                    when (animeEntity) {
                        is NetworkResponseState.Loading -> {
                            _animeUiState.postValue(AnimeUiState.Loading)
                        }
                        is NetworkResponseState.Error -> {
                            _animeUiState.postValue(AnimeUiState.Error(R.string.eror))
                        }
                        is NetworkResponseState.Success -> {
                            animeList = animeUiMapper.map(animeEntity.result!!)
                            when (favoritesEntity) {
                                is NetworkResponseState.Success -> {
                                    favoriteAnimeList = favoritesEntity.result!!
                                    animeList.map { anime ->
                                        favoriteAnimeList.forEach { favoritesEntity ->
                                            if (anime.malId == favoritesEntity.id) {
                                                anime.isFavorites = true
                                            }
                                        }
                                    }
                                    _animeUiState.postValue(AnimeUiState.Success(animeList))
                                }
                                else -> {
                                    _animeUiState.postValue(AnimeUiState.Success(animeList))
                                }
                            }
                        }
                    }
                }.catch {
                Log.e("view model anime ", it.toString())
                _animeUiState.postValue(AnimeUiState.Error(R.string.eror))
            }.collect()
        }
    }

    fun addFavoriteAnime(favoritesEntity: FavoritesEntity) {
        viewModelScope.launch {
            addFavoriteUsecase.invoke(favoritesEntity).collect {
                when (it) {
                    is NetworkResponseState.Success -> {
                        _addFavoriteState.postValue(AddFavoriteAnimeUiState.Success(it.result!!))
                    }
                    is NetworkResponseState.Error -> {
                        _addFavoriteState.postValue(AddFavoriteAnimeUiState.Error(R.string.eror))
                    }
                    is NetworkResponseState.Loading -> {
                        _addFavoriteState.postValue(AddFavoriteAnimeUiState.Loading)
                    }
                }
            }
        }
    }
}