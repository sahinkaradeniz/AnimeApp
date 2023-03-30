package com.example.presentation.ui.animedetail

import com.example.domain.entity.AnimeDetailEntity
import com.example.data.mapper.anime.AnimeMapper
import javax.inject.Inject

class  AnimeDetailUiMapper @Inject constructor():
    AnimeMapper<AnimeDetailEntity, AnimeDetailUiData> {
    override fun map(input: AnimeDetailEntity?): AnimeDetailUiData {
        return AnimeDetailUiData(
            malId =input?.malId,
            images =input?.images,
            titleEnglish = input?.titleEnglish,
            score = input?.score,
            background = input?.background,
            time = input?.time,
            timezone = input?.timezone,
            day = input?.day
        )
    }
}