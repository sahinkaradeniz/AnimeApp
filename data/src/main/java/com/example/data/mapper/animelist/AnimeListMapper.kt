package com.example.data.mapper.animelist

import com.example.data.mapper.anime.AnimeMapper

interface AnimeListMapper<I,O>: AnimeMapper<List<I>, List<O>> {
}