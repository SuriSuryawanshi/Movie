package com.suraj.movie.models

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey


@Entity
data class Movies(
    val overview: String,
    val original_language: String,
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val original_title: String,
    val title: String,
    val poster_path: String? = null,
    val backdrop_path:String? = null,
    val vote_average : String
) {
}