package com.alfred0ga.moviedbapp.repositories

import com.alfred0ga.moviedbapp.data.remote.RetrofitInstance

class MovieRepository() {
    suspend fun getMoviesfromAPI() = RetrofitInstance.api.getPopulatMovies()
}