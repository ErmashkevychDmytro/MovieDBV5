package com.example.moviedb.di.component

import com.example.moviedb.di.module.RepositoryModule
import com.example.moviedb.di.scope.RepositoryScope
import com.example.moviedb.repository.MovieRepository
import dagger.Component

@RepositoryScope
@Component(
    modules = [RepositoryModule::class],
    dependencies = [NetworkComponent::class, DataBaseComponent::class]
)
interface RepositoryComponent {
    val movieRepository:MovieRepository

}