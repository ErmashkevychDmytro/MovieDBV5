package com.example.moviedb.presentation.detail.adapter

import com.example.moviedb.data_source.database.entity.ActorEntity


interface ActorMovieListener {
    fun onClickActor(actor: ActorEntity)
}