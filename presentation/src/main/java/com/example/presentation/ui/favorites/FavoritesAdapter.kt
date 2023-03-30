package com.example.presentation.ui.favorites

import android.view.ViewGroup
import com.example.common.base.BaseRecyclerViewAdapter
import com.example.data.dto.favorite.FavoritesDbModel
import com.example.domain.entity.FavoritesEntity

class FavoritesAdapter(private val itemClick:((FavoritesEntity)->Unit)?):BaseRecyclerViewAdapter<FavoritesEntity,FavoritesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoritesViewHolder {
      return  FavoritesViewHolder.createFrom(parent,itemClick)
    }
}