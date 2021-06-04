package com.example.moviedb.di.module

import com.example.moviedb.data_source.DataSource
import com.example.moviedb.di.scope.RepositoryScope
import com.example.moviedb.remote_data_source.RemoteDataSource
import com.example.moviedb.repository.MovieRepository
import com.example.moviedb.repository.MovieRepositoryImpl
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {
    @RepositoryScope
    @Provides
    internal fun providesFeedRepository(
        remoteDataSource: RemoteDataSource,
        dataSource: DataSource
    ): MovieRepository {
        return MovieRepositoryImpl(dataSource, remoteDataSource)
    }
}