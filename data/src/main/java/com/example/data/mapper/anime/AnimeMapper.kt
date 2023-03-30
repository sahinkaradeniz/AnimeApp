package com.example.data.mapper.anime

interface AnimeMapper<I,O> {
    fun map(input:I?):O
}