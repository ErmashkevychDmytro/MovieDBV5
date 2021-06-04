package com.example.moviedb.di.component

import com.example.moviedb.di.module.ViewModelModule
import com.example.moviedb.di.scope.ViewModelScope
import com.example.moviedb.main.MainActivity
import com.example.moviedb.main.actor.ActorActivity
import com.example.moviedb.presentation.detail.DetailActivity
import dagger.Component

@ViewModelScope
@Component(modules = [ViewModelModule::class],dependencies = [UseCaseComponent::class])
interface ViewModelComponent {
    fun inject(activity: MainActivity)

    fun inject(activity: DetailActivity)

    fun inject(activity: ActorActivity)
}