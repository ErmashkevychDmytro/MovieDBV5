package com.example.moviedb.di.component

import com.example.moviedb.di.module.NetworkModule
import com.example.moviedb.di.scope.NetworkScope
import com.example.moviedb.remote_data_source.RemoteDataSource
import dagger.Component

@NetworkScope
@Component(modules = [NetworkModule::class],dependencies = [AppComponent::class])
interface NetworkComponent {
    val repositoryNetworkScope:RemoteDataSource
}