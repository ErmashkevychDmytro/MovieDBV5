package com.example.moviedb.di.module

import com.example.moviedb.data_source.DataSource
import com.example.moviedb.data_source.DataSourceImpl
import com.example.moviedb.data_source.database.MovieDataBase
import dagger.Module
import dagger.Provides


@Module
class DataBaseModule(private val movieDataBase: MovieDataBase) {

    @Provides
    internal fun providesAppDataBase(): MovieDataBase{
        return movieDataBase

    }

    @Provides
    internal fun providesFeedDataSource(movieDataBase: MovieDataBase): DataSource {
        return DataSourceImpl(movieDataBase)
    }
}