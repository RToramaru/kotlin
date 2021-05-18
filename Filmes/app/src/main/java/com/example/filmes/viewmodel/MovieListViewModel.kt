package com.example.filmes.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.filmes.api.MovieRestApiTask
import com.example.filmes.model.Movie
import com.example.filmes.repository.MovieRepository

class MovieListViewModel : ViewModel(){

    companion object{
        const val TAG = "MovieListViewModel"
    }

    private val movieRestApiTask = MovieRestApiTask()
    private val movieRepository = MovieRepository(movieRestApiTask)


    private var _moviesList = MutableLiveData<List<Movie>>()
    val moviesList: LiveData<List<Movie>>
    get() = _moviesList

    fun init(){
        getAllMovies()
    }

    private fun getAllMovies(){
        Thread{
            try{
                _moviesList.postValue(movieRepository.getAllMovies())
            } catch (exception:Exception) {
                Log.e(TAG, exception.message.toString())
            }
        }.start()
    }
}