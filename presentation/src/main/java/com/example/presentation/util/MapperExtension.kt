package com.example.presentation.util

import com.example.domain.entity.FavoritesEntity
import com.example.presentation.ui.anime.AnimeUiData
import com.example.presentation.ui.animedetail.AnimeDetailUiData


fun AnimeUiData.toFavorite()=FavoritesEntity(
    id= this.malId ,
    image= this.images.toString(),
    title = this.titleEnglish
)
fun AnimeDetailUiData.toFavorite()=FavoritesEntity(
    id= this.malId ,
    image= this.images.toString(),
    title = this.titleEnglish.toString()
)