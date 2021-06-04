package com.example.moviedb.di.component

import com.example.moviedb.di.module.AppModule
import com.example.moviedb.di.scope.AppScope
import com.google.gson.Gson
import dagger.Component


@AppScope
@Component(modules = [AppModule::class])
interface AppComponent {
    val gson:Gson
}