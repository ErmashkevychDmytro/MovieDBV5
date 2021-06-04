package com.example.moviedb.remote_data_source.pojo


import com.google.gson.annotations.SerializedName

data class SearchActorResponse(

    @SerializedName("results")
    val results: List<KnownForResponse>
)

