package com.example.filmes.repository

import android.util.Log
import com.example.filmes.api.MovieRestApiTask
import com.example.filmes.model.Movie

class MovieRepository(private val movieRestApiTask: MovieRestApiTask) {

    companion object{
        const val TAG = "MovieRepository"
    }

    private val movieList = arrayListOf<Movie>()

    fun getAllMovies():List<Movie> {
        val request = movieRestApiTask.retrofitApi().getAllMovie().execute()
        if (request.isSuccessful) {
            request.body()?.let {
                movieList.addAll(it)
            }
        } else {
            request.errorBody()?.let {
                Log.d(TAG, it.toString())
            }
        }
        return movieList
    }

}