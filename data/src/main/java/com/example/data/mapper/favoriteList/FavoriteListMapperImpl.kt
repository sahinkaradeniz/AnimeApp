package com.example.data.mapper.favoriteList

import com.example.data.dto.favorite.FavoritesDbModel
import com.example.domain.entity.FavoritesEntity
import javax.inject.Inject

class FavoriteListMapperImpl @Inject constructor():FavoriteListMapper<FavoritesDbModel,FavoritesEntity>{
    override fun map(input: List<FavoritesDbModel>?): List<FavoritesEntity> {
        return input?.map {
            FavoritesEntity(
                id = it.id,
                image = it.image,
                title = it.title
            )
        } ?: emptyList()
    }
}