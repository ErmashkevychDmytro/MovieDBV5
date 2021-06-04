package com.example.moviedb.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moviedb.R
import com.example.moviedb.data_source.database.entity.GenreEntity
import com.example.moviedb.main.MainActivity

class GenreRecyclerAdapter(
    private val listener: MainActivity
): RecyclerView.Adapter<GenreViewHolder>() {

    private var genrelist = mutableListOf<GenreEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreViewHolder {
        return GenreViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_genre,parent,false),
            listener
        )
    }

    override fun getItemCount(): Int = genrelist.size

    override fun onBindViewHolder(holder: GenreViewHolder, position: Int) {
        holder.bind(genrelist[position])
    }
    fun setData(genre : List<GenreEntity>){
        genrelist.clear()
        genrelist.addAll(genre)
        notifyDataSetChanged()
    }

}