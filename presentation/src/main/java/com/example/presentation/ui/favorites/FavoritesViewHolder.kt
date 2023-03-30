package com.example.presentation.ui.favorites

import android.view.ViewGroup
import com.example.common.base.BaseViewHolder
import com.example.common.extension.downloadFromUrl
import com.example.common.extension.inflateAdapterItem
import com.example.data.dto.favorite.FavoritesDbModel
import com.example.domain.entity.FavoritesEntity
import com.example.presentation.databinding.FavoritesItemBinding

class FavoritesViewHolder(
    private val binding: FavoritesItemBinding,
    private val favoriteClickListener: ((FavoritesEntity) -> Unit)?,
) : BaseViewHolder<FavoritesEntity>(binding.root) {
    companion object {
        fun createFrom(parent: ViewGroup, favoriteClickListener: ((FavoritesEntity) -> Unit)?) =
            FavoritesViewHolder(parent.inflateAdapterItem(FavoritesItemBinding::inflate),favoriteClickListener)
    }

    override fun onBind(data: FavoritesEntity) {
        binding.apply {
            favoriteTitle.text=data.title
            favoriteImage.downloadFromUrl(data.image)
            binding.favoriteDeleteButton.setOnClickListener {
                favoriteClickListener?.invoke(data)
            }
        }
    }
}