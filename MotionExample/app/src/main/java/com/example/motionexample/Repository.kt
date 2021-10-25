package com.example.motionexample

import javax.inject.Inject

class Repository @Inject constructor(
    private val localApi: LocalApi,
    private val retrofitServices: RetrofitServices
){
    private var listMovies : List<Movie>? = null

    suspend fun createMovies()
    {
        listMovies = retrofitServices.getMovieList().body()
        localApi.createMovieList(listMovies)
    }

    fun getMovies(): List<Movie>? {
        return localApi.getMovieList()
    }
}