package com.alfred0ga.moviedbapp.data.local.Entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie_table")
data class LocalMovie(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val backdropPath: String,
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
    val releaseDate: String,
)
