package com.example.moviedb.remote_data_source.pojo

import com.google.gson.annotations.SerializedName

data class TrailerResponse(
    @SerializedName("results")
    val result: List<KeyVideo>

)
