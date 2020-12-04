package com.alfred0ga.moviedbapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.alfred0ga.moviedbapp.data.local.Entities.LocalMovie

@Database(
    entities = [LocalMovie::class],
    version = 1
)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}