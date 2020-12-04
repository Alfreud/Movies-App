package com.alfred0ga.moviedbapp.ui

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.alfred0ga.moviedbapp.repositories.MovieRepository

class MainViewModelProviderFactory(
    val app: Application,
    val repository: MovieRepository
) :ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(app, repository) as T
    }
}