package com.example.presentation.ui.anime

import com.example.data.mapper.animelist.AnimeListMapper
import com.example.domain.entity.AnimeEntity
import javax.inject.Inject

class AnimeUiMapper @Inject constructor(): AnimeListMapper<AnimeEntity, AnimeUiData> {
    override fun map(input: List<AnimeEntity>?): List<AnimeUiData> {
        return input?.map {
            AnimeUiData(
                images = it.images,
                malId = it.malId,
                titleEnglish = it.titleEnglish,
                score = it.score,
                rating = it.rating
            )
        } ?: emptyList()
    }
}