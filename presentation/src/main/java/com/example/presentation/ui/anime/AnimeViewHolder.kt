package com.example.presentation.ui.anime

import android.view.ViewGroup
import com.example.common.base.BaseViewHolder
import com.example.common.extension.downloadFromUrl
import com.example.common.extension.inflateAdapterItem
import com.example.domain.entity.FavoritesEntity
import com.example.presentation.databinding.AnimeItemBinding
import com.example.presentation.util.toFavorite

class AnimeViewHolder(
    private val binding:AnimeItemBinding,
    private val itemClick :((Int)->Unit)?,
    private val favoriteClick:((FavoritesEntity)->Unit)?
): BaseViewHolder<AnimeUiData>(binding.root) {
    companion object{
        fun createFrom(parent: ViewGroup, itemClickListener : ((Int) -> Unit)?,favoriteClickListener:((FavoritesEntity)->Unit)?) =
           AnimeViewHolder(parent.inflateAdapterItem(AnimeItemBinding::inflate),itemClickListener,favoriteClickListener)
    }
    override fun onBind(data: AnimeUiData) {
        binding.apply {
            animeImage.downloadFromUrl(data.images)
            animeTitle.text=data.titleEnglish
            animeRate.text=data.score.toString()
            animeImage.setOnClickListener {
                itemClick?.invoke(data.malId)
            }
            animeFavorite.setOnClickListener {
                favoriteClick?.invoke(data.toFavorite())
            }
        }
    }
}
