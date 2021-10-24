package com.example.motionexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.motionexample.databinding.ActivityBdBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class BdActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBdBinding
    private lateinit var adapter: MyCatsDbAdapter

    @Inject
    lateinit var repo: ProjectDbRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bd)
       // repo = ProjectDbRepository(MyCatsDao())
        initProjectsRecycler(repo.getAllCats())

        binding.addCatButton.setOnClickListener {
            repo.insertCat(MyCatsDb("Simba"))
        }
    }

    private fun initProjectsRecycler(list: List<MyCatsDb>) {
        adapter = MyCatsDbAdapter(list)
        binding.catsRecycler.adapter = adapter
        binding.catsRecycler.layoutManager = LinearLayoutManager(this)

    }
}