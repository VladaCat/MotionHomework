package com.example.motionexample

import android.content.Intent

import android.R
import android.app.Service

import android.media.MediaPlayer

import android.os.IBinder
import java.lang.UnsupportedOperationException


class MediaCatService : Service() {
    var ambientMediaPlayer: MediaPlayer? = null
    override fun onBind(intent: Intent?): IBinder? {
        throw UnsupportedOperationException("Not yet implemented")
    }

    override fun onCreate() {
        //ambientMediaPlayer = MediaPlayer.create(this, R.raw.skidz)
        ambientMediaPlayer!!.isLooping = true
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        ambientMediaPlayer!!.start()
        return START_STICKY
    }

    override fun onDestroy() {
        ambientMediaPlayer!!.stop()
    }
}