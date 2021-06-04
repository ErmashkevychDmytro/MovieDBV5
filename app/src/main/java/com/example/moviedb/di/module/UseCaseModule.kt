package com.example.moviedb.di.module

import com.example.moviedb.di.scope.UseCaseScope
import com.example.moviedb.repository.MovieRepository
import com.example.moviedb.use_case.*
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @UseCaseScope
    @Provides
    internal fun providesMovieUseCase(repository: MovieRepository): MovieUseCase {
        return MovieUseCaseImpl(repository)
    }

    @UseCaseScope
    @Provides
    internal fun providesFindAndShowMovieByIdUseCase(repository: MovieRepository): FindAndShowMovieByIdUseCase {
        return FindAndShowMovieByIdUseCaseImpl(repository)
    }


    @UseCaseScope
    @Provides
    internal fun providesActorInfoUseCase(repository: MovieRepository):ActorInfoUseCase{
        return ActorInfoUseCaseImpl(repository)
    }
}