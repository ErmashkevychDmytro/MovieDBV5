package com.example.moviedb.main


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.moviedb.MovieApp
import com.example.moviedb.di.component.ViewModelComponent

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        createDaggerDependencies()
    }



    protected abstract fun injectDependency(component: ViewModelComponent)

    private fun createDaggerDependencies() {
        injectDependency((application as MovieApp).getViewModelComponent())
    }
}