package com.example.data.mapper.favorite

interface FavoriteMapper<I,O> {
    fun map(input:I?):O
}