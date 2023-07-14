package com.suraj.movie.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.suraj.movie.models.Movies

@Dao
interface MovieDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addMovies(movies : List<Movies>)

    @Query("SELECT * FROM Movies")
    suspend fun getMovies() : List<Movies>

}