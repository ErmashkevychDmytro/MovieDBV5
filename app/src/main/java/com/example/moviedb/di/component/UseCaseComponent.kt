package com.example.moviedb.di.component

import com.example.moviedb.di.module.UseCaseModule
import com.example.moviedb.di.scope.UseCaseScope
import com.example.moviedb.use_case.ActorInfoUseCase
import com.example.moviedb.use_case.FindAndShowMovieByIdUseCase
import com.example.moviedb.use_case.MovieUseCase
import dagger.Component


@UseCaseScope
@Component(modules = [UseCaseModule::class],dependencies = [RepositoryComponent::class])
interface UseCaseComponent {
    val movieUseCase:MovieUseCase
    val findAndShowMovieByIdUseCase:FindAndShowMovieByIdUseCase
    val actorInfoUseCase:ActorInfoUseCase
}