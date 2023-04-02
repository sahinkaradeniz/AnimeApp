package com.example.presentation.ui.favorites

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.NetworkResponseState
import com.example.domain.entity.FavoritesEntity
import com.example.domain.usecase.favoriteusecase.deletefavoriteusecase.DeleteFavoriteUseCase
import com.example.domain.usecase.favoriteusecase.getallfavoritesusecase.GetAllFavoritesUseCase
import com.example.presentation.R
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor(
    private val getAllFavoritesUseCase: GetAllFavoritesUseCase,
    private val deleteFavoriteUseCase: DeleteFavoriteUseCase,
) : ViewModel() {
    private val _favoritesListState = MutableLiveData<FavoritesUiState>()
    val favoritesListState: LiveData<FavoritesUiState> get() = _favoritesListState

    private val _deleteFavoriteState = MutableLiveData<DeleteFavoritesUiState>()
    val deleteFavoriteState: LiveData<DeleteFavoritesUiState> get() = _deleteFavoriteState



    fun getFavoritesList() {
        viewModelScope.launch {
            getAllFavoritesUseCase.invoke().collect{
                when(it){
                    is NetworkResponseState.Error ->{
                        _favoritesListState.postValue(FavoritesUiState.Error(R.string.eror))
                    }
                    is NetworkResponseState.Success ->{
                        _favoritesListState.postValue(FavoritesUiState.Success(it.result!!))
                    }
                    is NetworkResponseState.Loading ->{
                        _favoritesListState.postValue(FavoritesUiState.Loading)
                    }
                }

            }
        }
    }

    fun deleteFromFavorite(favoritesEntity: FavoritesEntity) {
        viewModelScope.launch {
            deleteFavoriteUseCase.invoke(favoritesEntity).collect{
                when(it){
                    is NetworkResponseState.Success->{
                        getFavoritesList()
                        _deleteFavoriteState.postValue(DeleteFavoritesUiState.Success(it.result!!))
                    }
                    is NetworkResponseState.Error ->{
                        _deleteFavoriteState.postValue(DeleteFavoritesUiState.Error(R.string.eror))
                    }
                    is NetworkResponseState.Loading ->{
                        _deleteFavoriteState.postValue(DeleteFavoritesUiState.Loading)
                    }
                }
            }
        }
    }
}