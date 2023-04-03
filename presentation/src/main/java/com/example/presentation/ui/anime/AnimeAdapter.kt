package com.example.presentation.ui.anime

import com.example.common.base.BaseRecyclerViewAdapter
import android.view.ViewGroup
import com.example.data.dto.favorite.FavoritesDbModel
import com.example.domain.entity.FavoritesEntity

class AnimeAdapter(private val itemClickListener: ((Int,Int) -> Unit)?,private val favoriteClickListener : ((FavoritesEntity)-> Unit)?):
    BaseRecyclerViewAdapter<AnimeUiData, AnimeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {
       return AnimeViewHolder.createFrom(parent,itemClickListener,favoriteClickListener)
    }
}