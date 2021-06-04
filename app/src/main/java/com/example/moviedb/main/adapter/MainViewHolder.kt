package com.example.moviedb.main.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviedb.data_source.database.entity.MovieEntity
import com.example.moviedb.main.MainActivity
import kotlinx.android.synthetic.main.item_movie.view.*

class MainViewHolder(
    itemView: View,
    private val listener: MainActivity

): RecyclerView.ViewHolder(itemView) {

    private val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"
    fun bind(movie: MovieEntity){
        itemView.textMovieTitle.text = movie.title
        Glide.with(itemView)
            .load(IMAGE_BASE + movie.posterPath)
            .into(itemView.imageMoviePoster)

        itemView.setOnClickListener {
            listener.onClickMovie(movie)
        }

    }
}