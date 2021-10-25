package com.example.motionexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.motionexample.databinding.ActivityRetrofitBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RetrofitActivity : AppCompatActivity() {

    private val viewModel by lazy{ ViewModelProvider(this).get(ViewModel::class.java)}
    private lateinit var binding: ActivityRetrofitBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit)

        viewModel.createMovie()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_retrofit)
        binding.lifecycleOwner = this

        binding.getMoviesButton?.setOnClickListener {
            binding.getMovieRecyclerView?.layoutManager = LinearLayoutManager(this)
            binding.getMovieRecyclerView?.adapter = MovieAdapter(viewModel.getMovieList())
             var movieList = viewModel.getMovieList()
        }
    }
}