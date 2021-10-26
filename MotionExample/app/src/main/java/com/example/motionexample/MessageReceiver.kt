package com.example.motionexample

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MessageReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val mode = intent.getBooleanExtra("mode", true)
        if(mode) {
            Toast.makeText(context, Intent.ACTION_POWER_CONNECTED, Toast.LENGTH_LONG).show()
        }
    }
}