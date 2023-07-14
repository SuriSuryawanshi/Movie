package com.suraj.movie.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.suraj.movie.db.MovieDB
import com.suraj.movie.models.Movies
import com.suraj.movie.models.ResponseMovie
import com.suraj.movie.retrofit.MovieAPI
import com.suraj.movie.utills.Constants
import javax.inject.Inject

class MovieRepository @Inject constructor(private val movieAPI: MovieAPI, private val movieDB: MovieDB) {

    private val _movies = MutableLiveData<List<Movies>>()
    val movies: LiveData<List<Movies>>
        get() = _movies

    private val isloading = MutableLiveData<Boolean>()
    val _isloading: LiveData<Boolean>
        get() = isloading

    suspend fun getMovies(qry : String){
        val result = movieAPI.getMovies(Constants.API_KEY,qry,false,"en_Us",1)
        if(result.isSuccessful && result.body() != null){
            //movieDB.getMovieDAO().addMovies(result.body()!!.results)
            _movies.postValue(result.body()!!.results)
            isloading.postValue(true)
        }else{
            isloading.postValue(false)
        }
    }

    suspend fun getTrendingMovies(){
        val result = movieAPI.getTrendingMovies(Constants.API_KEY)
        if(result.isSuccessful && result.body() != null){
             //movieDB.getMovieDAO().addMovies(result.body()!!.results)
            _movies.postValue(result.body()!!.results)
            isloading.postValue(true)
        }else{
            isloading.postValue(false)
        }
    }

    fun getLoadingState(): LiveData<Boolean> {
       return _isloading
    }

}