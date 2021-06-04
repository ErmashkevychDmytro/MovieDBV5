package com.example.moviedb.remote_data_source.pojo

import com.example.moviedb.data_source.database.entity.ActorEntity
import com.google.gson.annotations.SerializedName

data class CastResponse(

@SerializedName("id")
val id: Int,

@SerializedName("cast")
val cast: List<ActorEntity>
)