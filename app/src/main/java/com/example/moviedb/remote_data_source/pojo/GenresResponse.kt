package com.example.moviedb.remote_data_source.pojo

import com.example.moviedb.data_source.database.entity.GenreEntity
import com.google.gson.annotations.SerializedName

class GenresResponse (

    @SerializedName("genres")
    val genres: List<GenreEntity>
    )