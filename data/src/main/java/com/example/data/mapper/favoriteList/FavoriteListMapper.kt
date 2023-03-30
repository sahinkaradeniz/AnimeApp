package com.example.data.mapper.favoriteList

import com.example.data.mapper.favorite.FavoriteMapper

interface FavoriteListMapper<I,O>:FavoriteMapper<List<I>,List<O>> {
}