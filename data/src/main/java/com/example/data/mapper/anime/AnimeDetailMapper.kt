package com.example.data.mapper.anime

import com.example.data.dto.animes.anime.DetailData
import com.example.data.mapper.anime.AnimeMapper
import com.example.domain.entity.AnimeDetailEntity

import javax.inject.Inject

class AnimeDetailMapper @Inject constructor(): AnimeMapper<DetailData, AnimeDetailEntity> {
    override fun map(input: DetailData?):AnimeDetailEntity {
        return AnimeDetailEntity(
            malId = input?.malId,
            images = input?.images?.imageUrl ?: input?.trailer?.images?.largeImageUrl,
            trailer = input?.trailer?.url,
            titleEnglish = input?.titleEnglish,
            type = input?.type,
            episodes = input?.episodes,
            rating = input?.rating,
            score = input?.score,
            rank = input?.rank,
            popularity = input?.popularity,
            synopsis = input?.synopsis,
            background = input?.background,
            season = input?.season,
            year = input?.year,
            day = input?.broadcast?.day,
            time = input?.broadcast?.time,
            timezone = input?.broadcast?.timezone
        )
    }
}