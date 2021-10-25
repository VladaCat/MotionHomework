package com.example.motionexample

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalApi @Inject constructor(){

    private var movieList:List<Movie>? = null
    fun createMovieList(list: List<Movie>?){
        movieList =list
    }

    fun getMovieList():List<Movie>?{
        return movieList
    }
}