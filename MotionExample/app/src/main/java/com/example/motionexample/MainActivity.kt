package com.example.motionexample

import android.app.Notification
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.databinding.DataBindingUtil
import com.example.motionexample.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val receiverMessage = MessageReceiver()

    companion object {
        const val NOTIFICATION_ID = 101
        const val CHANNEL_ID = "channelID"
    }
    val WHERE_MY_CAT_ACTION = "cat"
    val ALARM_MESSAGE = "Give me my cat!"
//    val CHANNEL_ID = "channelID"
//    val NOTIFICATION_ID = 101

    fun sendMessage(view: View?) {
 //       val intent = Intent()
//        intent.action = WHERE_MY_CAT_ACTION
//        intent.putExtra("cat", ALARM_MESSAGE)
//        intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES)
//        sendBroadcast(intent)
    }
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

        binding.makeBdButton.setOnClickListener {
            val bdIntent = Intent(this, BdActivity::class.java)
            startActivity(bdIntent)
        }

        binding.movieButton.setOnClickListener {
            val movieIntent = Intent(this, RetrofitActivity::class.java)
            startActivity(movieIntent)
        }

        binding.sendMessageButton.setOnClickListener {
            val filterIntent = IntentFilter()
            filterIntent.addAction(Intent.ACTION_POWER_CONNECTED)
            registerReceiver(receiverMessage, filterIntent)
//            val intent = Intent()
//            intent.action = WHERE_MY_CAT_ACTION
//            intent.putExtra("cat", ALARM_MESSAGE)
//            sendBroadcast(intent)

            // Создаём уведомление
//        binding.sendMessageButton.setOnClickListener {
//            val broadCastEx = NotificationCompat.Builder(this, CHANNEL_ID)
//                .setSmallIcon(R.drawable.ic_cat)
//                .setContentTitle("Notification")
//                .setContentText(ALARM_MESSAGE)
//                .setDefaults(Notification.DEFAULT_VIBRATE)
//                .setAutoCancel(true)
//                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
//
//            with(NotificationManagerCompat.from(this)){
//                notify(NOTIFICATION_ID, broadCastEx.build())
//            }
//        }
        }


    }

    fun click(v: View) {
        val i = Intent(this, MediaCatService::class.java)
        binding.startMediaButton.setOnClickListener { startService(i) }
        binding.stopMediaButton.setOnClickListener { stopService(i) }
    }
}