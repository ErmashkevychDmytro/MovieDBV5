package com.example.moviedb.main.adapter

import com.example.moviedb.data_source.database.entity.GenreEntity


interface GenreListener {
    fun onClickGenre(genre: GenreEntity)
}