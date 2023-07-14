package com.suraj.movie.viewmodel

import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.suraj.movie.models.Movies
import com.suraj.movie.repository.MovieRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(private val repository: MovieRepository) : ViewModel() {

    val moviesLiveData : LiveData<List<Movies>>
        get() = repository.movies

    init {
        viewModelScope.launch {
            delay(10000)
            repository.getTrendingMovies()
        }
    }

    fun listenTosearch(serachqry: String) {
        viewModelScope.launch {
            delay(10000)
            repository.getMovies(serachqry)
        }
    }

    fun showProgressBar(): LiveData<Boolean> {
        return repository.getLoadingState()
    }


}