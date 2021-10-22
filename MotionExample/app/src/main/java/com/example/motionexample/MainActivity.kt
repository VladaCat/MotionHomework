package com.example.motionexample

import android.content.Intent
import android.gesture.Gesture
import android.gesture.GestureLibraries
import android.gesture.GestureOverlayView
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.motionexample.databinding.ActivityMainBinding
import androidx.databinding.DataBindingUtil
import android.gesture.GestureLibrary
import android.view.View

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this

        binding.goToMotionButton.setOnClickListener {
            val motionIntent = Intent(this, HelloMotion::class.java)
            startActivity(motionIntent)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_in_left);
        }

        binding.startDrawingButton.setOnClickListener {
            val drawingIntent = Intent(this, HelloDrawer::class.java)
            startActivity(drawingIntent)
        }

        binding.startMediaButton.setOnClickListener {
            val startMediaIntent = Intent(this, MediaCatService::class.java)
            startService(startMediaIntent)
        }

        binding.stopMediaButton.setOnClickListener {
            val stopMediaIntent = Intent(this, MediaCatService::class.java)
            stopService(stopMediaIntent)
        }
    }

    fun click(v: View) {
        val i = Intent(this, MediaCatService::class.java)
        binding.startMediaButton.setOnClickListener { startService(i) }
        binding.stopMediaButton.setOnClickListener { stopService(i) }
    }
}