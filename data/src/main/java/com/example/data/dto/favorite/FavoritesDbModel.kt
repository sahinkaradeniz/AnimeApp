package com.example.data.dto.favorite

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity(tableName = "favorites_table")
data class FavoritesDbModel(
    @PrimaryKey
    var id: Int?= null,
    val title: String?,
    val image: String?,
)