package com.example.filmes.data

import com.example.filmes.domain.Movie

interface MovieDataSource {

    fun getAllMovies(): List<Movie>
}