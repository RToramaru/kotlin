package com.example.filmes.api

import com.example.filmes.model.Movie
import retrofit2.Call
import retrofit2.http.GET

interface MovieApi {
    //https://raw.githubusercontent.com/natanfelipe/FilmesFlixJson/master/moviesList
    @GET("natanfelipe/FilmesFlixJson/master/moviesList")
    fun getAllMovie(): Call<List<Movie>>
}