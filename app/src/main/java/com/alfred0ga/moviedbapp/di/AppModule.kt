package com.alfred0ga.moviedbapp.di

import android.content.Context
import androidx.room.Room
import com.alfred0ga.moviedbapp.data.local.MovieDatabase
import com.alfred0ga.moviedbapp.data.remote.TMDBApi
import com.alfred0ga.moviedbapp.util.constants.BASE_URL
import com.alfred0ga.moviedbapp.util.constants.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideMovieDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(context, MovieDatabase::class.java, DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideMovieDao(
        database: MovieDatabase
    ) = database.movieDao()

    @Singleton
    @Provides
    fun provideTMDBApi(): TMDBApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(TMDBApi::class.java)
    }
}