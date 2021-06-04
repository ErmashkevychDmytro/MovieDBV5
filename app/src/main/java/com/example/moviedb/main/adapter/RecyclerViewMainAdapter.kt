package com.example.moviedb.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moviedb.R
import com.example.moviedb.data_source.database.entity.MovieEntity
import com.example.moviedb.main.MainActivity

class RecyclerViewMainAdapter(
        private val listener: MainActivity
):RecyclerView.Adapter<MainViewHolder>(){

    private var movielist = mutableListOf<MovieEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_movie,parent,false),
            listener
        )
    }

    override fun getItemCount(): Int = movielist.size

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(movielist[position])
    }
    fun setData(movie : List<MovieEntity>){
        movielist.clear()
        movielist.addAll(movie)
        notifyDataSetChanged()
    }
}
