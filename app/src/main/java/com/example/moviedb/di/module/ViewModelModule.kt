package com.example.moviedb.di.module

import android.app.Application
import com.example.moviedb.MovieApp
import com.example.moviedb.di.scope.ViewModelScope
import com.example.moviedb.use_case.ActorInfoUseCase
import com.example.moviedb.use_case.FindAndShowMovieByIdUseCase
import com.example.moviedb.use_case.MovieUseCase
import com.example.moviedb.view_model.ActorInfoViewModel
import com.example.moviedb.view_model.DetailViewModel
import com.example.moviedb.view_model.MainViewModel
import dagger.Module
import dagger.Provides

@Module
class ViewModelModule (app:MovieApp) {
    internal var app: Application = app

    @ViewModelScope
    @Provides
    internal fun providesMainViewModel(movieUseCase: MovieUseCase):MainViewModel{
     return MainViewModel(movieUseCase)
    }

    @ViewModelScope
    @Provides
    internal fun providesDetailViewModel(findAndShowMovieByIdUseCase: FindAndShowMovieByIdUseCase):DetailViewModel{
        return DetailViewModel(findAndShowMovieByIdUseCase)

    }

    @ViewModelScope
    @Provides
    internal fun providesActorInfoViewModel(actorInfoUseCase: ActorInfoUseCase):ActorInfoViewModel{
        return ActorInfoViewModel(actorInfoUseCase)
    }



}

