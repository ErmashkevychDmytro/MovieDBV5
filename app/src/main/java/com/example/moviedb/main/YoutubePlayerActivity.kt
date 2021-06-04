package com.example.moviedb.main

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import com.example.moviedb.R
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import kotlinx.android.synthetic.main.youtube_main.*

class YoutubePlayerActivity : YouTubeBaseActivity() {

     companion object {
         private const val YOU_TUBE_PREFIX = "https://www.youtube.com/watch?v="
     }

     override fun onCreate(p0: Bundle?) {
         super.onCreate(p0)
         setContentView(R.layout.youtube_main)
         intent.getStringExtra("movie_id")?.let { key->
             // Example valid video: https://www.youtube.com/watch?v=Rbuzbij9fAY
             Log.d("YouTube", "Trying link: [https://www.youtube.com/watch?v=$key]")
             initializePlayer("$YOU_TUBE_PREFIX$key")
             btnYouTube.setOnClickListener {
                 startActivity(Intent().apply {
                     action = Intent.ACTION_VIEW
                     data = Uri.parse("$YOU_TUBE_PREFIX$key")
                 })
             }
         }
     }

    private fun initializePlayer(videoId: String) {
        youtubePlayer?.initialize(getString(R.string.api_key_2),
            object : YouTubePlayer.OnInitializedListener {
                override fun onInitializationSuccess(
                    p0: YouTubePlayer.Provider?,
                    p1: YouTubePlayer?,
                    p2: Boolean
                ) {
                    p1!!.loadVideo(videoId)
                    p1.play()

                }

                override fun onInitializationFailure(
                    p0: YouTubePlayer.Provider?,
                    p1: YouTubeInitializationResult?
                ) {
                    Log.d("YouTube", "error | provider = $p0")
                    Log.d("YouTube", "error | result = $p1")
                }

            })
    }
}

