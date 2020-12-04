package com.alfred0ga.moviedbapp.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.alfred0ga.moviedbapp.repositories.MovieRepository
import kotlinx.coroutines.launch

class MainViewModel(
    app: Application,
    val repository: MovieRepository
) : AndroidViewModel(app) {

    init {
        //getMovies()
    }

    private fun getMovies() = viewModelScope.launch {
        val response = repository.getMoviesfromAPI()
        if (response.isSuccessful) {
            print("hello data")
        }
    }
}