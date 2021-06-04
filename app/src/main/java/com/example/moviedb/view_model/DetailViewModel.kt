package com.example.moviedb.view_model

import androidx.lifecycle.MutableLiveData
import com.example.moviedb.data_source.database.entity.ActorEntity
import com.example.moviedb.data_source.database.entity.MovieEntity
import com.example.moviedb.remote_data_source.pojo.KeyVideo
import com.example.moviedb.use_case.FindAndShowMovieByIdUseCase
import com.example.moviedb.utils.SingleLiveEvent
import io.reactivex.rxkotlin.plusAssign

class DetailViewModel (
        private val findAndShowMovieByIdUseCase: FindAndShowMovieByIdUseCase
        ):BaseViewModel() {

    val gotMovie = MutableLiveData<MovieEntity>()
    val gotMovieCast = MutableLiveData<List<ActorEntity>>()
    val gotVideoById = SingleLiveEvent<List<KeyVideo>>()

    fun getMovie(id: Int) {
        compositeDisposable += findAndShowMovieByIdUseCase.getMovieById(id = id)
                .subscribe({
                    showMovie(id)
                }, {
                    it.printStackTrace()

                })
    }

    private fun showMovie(id: Int) {
        compositeDisposable += findAndShowMovieByIdUseCase.showMovieInfo(id)
                .subscribe({ movie ->
                    gotMovie.value = movie
                }, {
                    it.printStackTrace()
                })
    }

     fun getMovieCast(id: Int){
        compositeDisposable += findAndShowMovieByIdUseCase.getMovieCast(id = id)
                .subscribe({
                    showMovieCast()
                }, {
                    it.printStackTrace()
                })

    }

    private fun showMovieCast(){
        compositeDisposable += findAndShowMovieByIdUseCase.showMovieCast()
                .subscribe({ movieCast ->
                    gotMovieCast.value = movieCast
                }, {
                    it.printStackTrace()
                })

    }

    fun getVideoById(id: Int){
        compositeDisposable += findAndShowMovieByIdUseCase.getVideoById(id = id)
            .subscribe({
                gotKey ->
                gotVideoById.value = gotKey
            }, {
                it.printStackTrace()
            })
    }

}
