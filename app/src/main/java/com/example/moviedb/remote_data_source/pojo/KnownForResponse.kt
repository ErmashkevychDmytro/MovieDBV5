package com.example.moviedb.remote_data_source.pojo

import com.example.moviedb.data_source.database.entity.MovieEntity
import com.google.gson.annotations.SerializedName

data class KnownForResponse (
    @SerializedName("known_for")
    val knowFor: List<MovieEntity>
        )