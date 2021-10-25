package com.example.motionexample

import androidx.lifecycle.ViewModel
import javax.inject.Inject

class UseCase @Inject constructor(private val repository: Repository):
    ViewModel(){
    suspend fun createMovie(){
        return repository.createMovies()
    }
    fun getMovieList(): List<Movie>? {
        return repository.getMovies()
    }
}