package com.suraj.movie.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.suraj.movie.models.Movies

@Database(entities = [Movies::class], version = 1,exportSchema = false)
abstract  class MovieDB  : RoomDatabase() {

    abstract fun getMovieDAO() : MovieDAO

}