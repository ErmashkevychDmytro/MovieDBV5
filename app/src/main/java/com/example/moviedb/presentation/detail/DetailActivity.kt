package com.example.moviedb.presentation.detail

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.moviedb.MovieApp
import com.example.moviedb.R
import com.example.moviedb.data_source.database.entity.ActorEntity
import com.example.moviedb.data_source.database.entity.MovieEntity
import com.example.moviedb.main.YoutubePlayerActivity
import com.example.moviedb.main.actor.ActorActivity
import com.example.moviedb.presentation.detail.adapter.ActorMovieListener
import com.example.moviedb.presentation.detail.adapter.DetailRecyclerAdapter
import com.example.moviedb.remote_data_source.pojo.KeyVideo
import com.example.moviedb.view_model.DetailViewModel
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.youtube_main.*
import javax.inject.Inject

class DetailActivity : AppCompatActivity(), ActorMovieListener {

    var detailViewModel: DetailViewModel? = null @Inject set
    val adapterListActor = DetailRecyclerAdapter(this)

    private val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        (application as MovieApp).getViewModelComponent().inject(this)


        val id = intent.getIntExtra("movie_id", -1)
        detailViewModel?.getMovie(id)
        detailViewModel?.getMovieCast(id)


        writeMovieInfo()
        writeActorList()
        startVideo()

        btnTrailer.setOnClickListener {
            id.takeIf { it != -1 }?.let {
                detailViewModel?.getVideoById(it)
            }
        }

    }

    private fun startVideo(){
        detailViewModel?.gotVideoById?.observe(this, Observer<List<KeyVideo>>{
            it.lastOrNull()?.let { key ->
                val nextScreen = Intent(this, YoutubePlayerActivity::class.java)
                    .putExtra("movie_id", key.key)
                Log.d("jopa", key.key)
                startActivity(nextScreen)
            }
        })
    }

    private fun writeActorList() {
        recyclerListActorsDetail.adapter = adapterListActor
        recyclerListActorsDetail.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        detailViewModel?.gotMovieCast?.observe(this, Observer<List<ActorEntity>> {
            adapterListActor.setData(it)
        })
    }


    private fun writeMovieInfo() {

        detailViewModel?.gotMovie?.observe(this, Observer<MovieEntity> { movie ->
            textTitleDetail.text = movie.title


            //Todo make good looking format
            textGenreDetail.text = movie.overview?.map { it.name }.toString()
            textvoteAverageDetail.text = movie.voteAverage
            Glide.with(this)
                .load(IMAGE_BASE + movie.posterPath)
                .into(imageMoviePosterDetail)
        })
    }

    override fun onClickActor(actor: ActorEntity) {
        val nextScreen = Intent(this, ActorActivity::class.java)
            .putExtra("actor_id", actor.id)
        startActivity(nextScreen)
    }

}
