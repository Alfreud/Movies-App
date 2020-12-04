package com.alfred0ga.moviedbapp.data.remote

import com.alfred0ga.moviedbapp.BuildConfig.API_KEY
import com.alfred0ga.moviedbapp.data.remote.responses.Movie
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBApi {

    @GET("3/movie/popular")
    suspend fun getPopulatMovies(
        @Query("api_key") api_key: String = API_KEY
    ): Response<List<Movie>>
}