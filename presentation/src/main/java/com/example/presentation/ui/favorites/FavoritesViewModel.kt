package com.example.presentation.ui.favorites

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.dto.favorite.FavoritesDbModel
import com.example.domain.entity.FavoritesEntity
import com.example.domain.usecase.favoriteusecase.deletefavoriteusecase.DeleteFavoriteUseCase
import com.example.domain.usecase.favoriteusecase.getallfavoritesusecase.GetAllFavoritesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor(
    private val getAllFavoritesUseCase: GetAllFavoritesUseCase,
    private val deleteFavoriteUseCase: DeleteFavoriteUseCase,
) : ViewModel() {
    private val _favoritesList = MutableLiveData<List<FavoritesEntity>>()
    val favoritesList: LiveData<List<FavoritesEntity>> get() = _favoritesList



     fun getFavoritesList() {
        viewModelScope.launch {
            getAllFavoritesUseCase.invoke().collect{
                _favoritesList.postValue(it)
            }
        }
    }

    fun deleteFromFavorite(favoritesEntity: FavoritesEntity) {
        viewModelScope.launch {
            deleteFavoriteUseCase.invoke(favoritesEntity)
            getFavoritesList()
        }
    }
}