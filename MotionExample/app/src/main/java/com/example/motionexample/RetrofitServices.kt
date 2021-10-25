package com.example.motionexample

import retrofit2.Response
import retrofit2.http.GET

interface RetrofitServices {
    @GET("marvel")
    suspend fun getMovieList(): Response<List<Movie>>
}