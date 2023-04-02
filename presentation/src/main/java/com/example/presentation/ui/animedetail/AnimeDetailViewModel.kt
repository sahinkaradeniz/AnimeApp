package com.example.presentation.ui.animedetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.NetworkResponseState
import com.example.domain.entity.AnimeDetailEntity
import com.example.data.mapper.anime.AnimeMapper
import com.example.domain.usecase.animeusecase.animedetailusecase.GetAnimeDetailUseCase
import com.example.domain.usecase.favoriteusecase.addfavoriteusecase.AddFavoriteUsecase
import com.example.presentation.R
import com.example.presentation.util.toFavorite
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnimeDetailViewModel @Inject constructor(
    private val getAnimeDetailUseCase: GetAnimeDetailUseCase,
    private val animeDetailUiMapper: AnimeMapper<AnimeDetailEntity, AnimeDetailUiData>,
    private val addFavoriteUsecase: AddFavoriteUsecase
): ViewModel() {
   private val _animeDetailState=MutableLiveData<AnimeDetailUiState>()
   val animeDetailState:LiveData<AnimeDetailUiState> get() = _animeDetailState

   private val _addFavoriteState = MutableLiveData<AddFavoriteAnimeDetailUiState>()
   val addFavoriteState: LiveData<AddFavoriteAnimeDetailUiState> get() = _addFavoriteState

   private lateinit var animeData:AnimeDetailUiData
   fun getAnimeDetail(id:Int){
      viewModelScope.launch {
         getAnimeDetailUseCase.invoke(id).collect{
            when(it){
               is NetworkResponseState.Loading ->{
                  _animeDetailState.postValue(AnimeDetailUiState.Loading)
               }
               is NetworkResponseState.Success ->{
                  animeData=animeDetailUiMapper.map(it.result)
                  _animeDetailState.postValue(AnimeDetailUiState.Success(animeData))
               }
               is  NetworkResponseState.Error->{
                  _animeDetailState.postValue(AnimeDetailUiState.Error(R.string.eror))
               }
            }
         }
      }
   }

   fun addAnimeToFavorites(){
      viewModelScope.launch {
            addFavoriteUsecase.invoke(animeData.toFavorite()).collect{
               when(it){
                  is NetworkResponseState.Success->{
                     _addFavoriteState.postValue(AddFavoriteAnimeDetailUiState.Success(it.result!!))
                  }
                  is NetworkResponseState.Error ->{
                     _addFavoriteState.postValue(AddFavoriteAnimeDetailUiState.Error(R.string.eror))
                  }
                  is NetworkResponseState.Loading ->{
                     _addFavoriteState.postValue(AddFavoriteAnimeDetailUiState.Loading)
                  }
               }
            }
      }
   }
}