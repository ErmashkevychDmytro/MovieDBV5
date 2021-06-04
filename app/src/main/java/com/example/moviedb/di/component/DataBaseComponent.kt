package com.example.moviedb.di.component


import com.example.moviedb.data_source.DataSource
import com.example.moviedb.di.module.DataBaseModule
import dagger.Component


@Component(modules = [DataBaseModule::class])
interface DataBaseComponent {
    val dataSource:DataSource
}