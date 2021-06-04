package com.example.moviedb.remote_data_source.mapper

import com.example.moviedb.data_source.database.entity.MovieEntity
import com.example.moviedb.remote_data_source.pojo.KnownForResponse

fun List<KnownForResponse>.mapToMovies(): List<MovieEntity> {
    val movies = arrayListOf<MovieEntity>()
    forEach {
        movies.addAll(it.knowFor)
    }
    return movies
}