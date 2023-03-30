package com.example.data.mapper.animelist

import com.example.data.dto.animes.allAnime.Data
import com.example.domain.entity.AnimeEntity
import javax.inject.Inject

class AnimeMainMapper @Inject constructor() : AnimeListMapper<Data, AnimeEntity> {
    override fun map(input: List<Data>?): List<AnimeEntity> {
        return input?.map {
            AnimeEntity(
                malId = it.malId,
                images = it.images.jpg?.largeImageUrl,
                titleEnglish = it.titleEnglish ?: it.title,
                rank = it.rank,
                rating = it.rating,
                popularity = it.popularity,
                year = it.year,
                score = it.score
            )
        } ?: emptyList()
    }
}
