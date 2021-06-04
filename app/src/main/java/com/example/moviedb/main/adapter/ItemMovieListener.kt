package com.example.moviedb.main.adapter

import com.example.moviedb.data_source.database.entity.MovieEntity

interface ItemMovieListener {
    fun onClickMovie(movie: MovieEntity)
}