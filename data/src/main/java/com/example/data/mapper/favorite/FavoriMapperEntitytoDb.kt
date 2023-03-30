package com.example.data.mapper.favorite

import com.example.data.dto.favorite.FavoritesDbModel
import com.example.domain.entity.FavoritesEntity
import javax.inject.Inject

class FavoriMapperEntitytoDb @Inject constructor():FavoriteMapper<FavoritesEntity,FavoritesDbModel> {
    override fun map(input: FavoritesEntity?): FavoritesDbModel {
        return FavoritesDbModel(
            id = input?.id,
            image = input?.image,
            title = input?.title
        )
    }
}