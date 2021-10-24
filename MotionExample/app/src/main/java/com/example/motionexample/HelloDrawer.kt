package com.example.motionexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.motionexample.databinding.ActivityHelloDrawerBinding


class HelloDrawer : AppCompatActivity() {
    private lateinit var binding :ActivityHelloDrawerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_hello_drawer)

        binding.clearButton.setOnClickListener {
            binding.field.extraCanvas.drawColor(getColor(R.color.colorBack))
        }
    }
}