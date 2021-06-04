package com.example.moviedb

import android.app.Application
import androidx.room.Room
import com.example.moviedb.data_source.database.MovieDataBase
import com.example.moviedb.di.component.*
import com.example.moviedb.di.module.*
import com.google.firebase.auth.FirebaseAuth

class MovieApp:Application() {
    private lateinit var viewModelComponent: ViewModelComponent
    private lateinit var database: MovieDataBase
    private var firebaseAuth: FirebaseAuth? = null

    override fun onCreate() {
        super.onCreate()

        initFirebaseAuth()
        initRoom()
        initDagger()
    }
    private fun initRoom(){
        database = Room.databaseBuilder(this,MovieDataBase::class.java,"database")
            .allowMainThreadQueries()
            .build()
    }



    private fun initDagger(){
        val appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()

        val networkComponent = DaggerNetworkComponent.builder()
            .appComponent(appComponent)
            .networkModule(NetworkModule())
            .build()

        val dataBaseComponent = DaggerDataBaseComponent.builder()
            .dataBaseModule(DataBaseModule(database))
            .build()
        val repositoryComponent = DaggerRepositoryComponent.builder()
            .networkComponent(networkComponent)
            .dataBaseComponent(dataBaseComponent)
            .repositoryModule(RepositoryModule())
            .build()

        val useCaseComponent = DaggerUseCaseComponent.builder()
            .repositoryComponent(repositoryComponent)
            .useCaseModule(UseCaseModule())
            .build()



        viewModelComponent = DaggerViewModelComponent.builder()
            .useCaseComponent(useCaseComponent)
            .viewModelModule(ViewModelModule(this))
            .build()

    }

    fun getViewModelComponent():ViewModelComponent {
        return this.viewModelComponent
    }

    private fun initFirebaseAuth() {
        firebaseAuth = FirebaseAuth.getInstance()
    }

    fun getFirebaseAuth(): FirebaseAuth {
        return this!!.firebaseAuth!!
    }

}