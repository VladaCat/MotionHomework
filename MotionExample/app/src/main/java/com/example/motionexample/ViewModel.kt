package com.example.motionexample

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModel @Inject constructor(private val useCase: UseCase): ViewModel() {
    fun createMovie(){

        viewModelScope.launch{
            useCase.createMovie()
        }
    }
    fun getMovieList(): List<Movie>? {
        return useCase.getMovieList()
    }
}