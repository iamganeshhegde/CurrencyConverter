package com.example.currencyconverter.miscellaneous.serviceLearning

import android.R
import android.app.*
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import com.example.currencyconverter.MainActivity


class ForegroundService : Service() {
//    override fun onBind(intent: Intent?): IBinder? {
//        return null
//    }
//
//    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
//
//        if (intent?.getAction()?.equals("startforeground") == true) {
//
//            var notifIntent = Intent(this, MainActivity::class.java)
//
//            notifIntent.action = "main"
//            notifIntent.setFlags(
//                Intent.FLAG_ACTIVITY_NEW_TASK
//                        or Intent.FLAG_ACTIVITY_CLEAR_TASK
//            )
//            var pendingIntent = PendingIntent.getActivity(this, 0, notifIntent, 0)
//
//
//            var prevIntent = Intent(this, ForegroundService::class.java)
//
//            prevIntent.action = "previous"
//            var pendingIntentprev = PendingIntent.getActivity(this, 0, prevIntent, 0)
//
//
//            var playIntent = Intent(this, ForegroundService::class.java)
//
//            playIntent.action = "play"
//            var pendingIntentplay = PendingIntent.getActivity(this, 0, playIntent, 0)
//
//
//            var nextIntent = Intent(this, ForegroundService::class.java)
//
//            nextIntent.action = "next"
//            var pendingIntentnext = PendingIntent.getActivity(this, 0, nextIntent, 0)
//
//
//            val icon = BitmapFactory.decodeResource(
//                resources,
//                R.drawable.btn_minus
//            )
//
//            var notification = NotificationCompat.Builder(this)
//                .setContentTitle("Truiton Music Player")
//                .setTicker("Truiton Music Player")
//                .setContentText("My Music")
//                .setSmallIcon(R.mipmap.sym_def_app_icon)
//                .setLargeIcon(icon)
//                .setContentIntent(pendingIntent)
//                .setOngoing(true)
//                .addAction(android.R.drawable.ic_media_previous, "previous", pendingIntentprev)
//                .addAction(
//                    android.R.drawable.ic_media_play, "Play",
//                    pendingIntentplay
//                )
//                .addAction(
//                    android.R.drawable.ic_media_next, "Next",
//                    pendingIntentnext
//                ).build();
//
//
//            startForeground(101, notification)
//
//        } else if (intent?.getAction().equals("previous")) {
//            Log.i("LOG_TAG", "Clicked Previous");
//        } else if (intent?.getAction().equals("play")) {
//            Log.i("LOG_TAG", "Clicked Play");
//        } else if (intent?.getAction().equals("next")) {
//            Log.i("LOG_TAG", "Clicked Next");
//        } else if (intent?.getAction().equals(
//                "stopforeground"
//            )
//        ) {
//            Log.i("LOG_TAG", "Received Stop Foreground Intent");
//            stopForeground(true);
//            stopSelf();
//        }
//
//        return START_STICKY
//
//
//    }


    private val LOG_TAG = "ForegroundService"
    override fun onCreate() {
        super.onCreate()
    }

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        if (intent.action == Constants.ACTION.STARTFOREGROUND_ACTION) {
            Log.i(LOG_TAG, "Received Start Foreground Intent ")
            val notificationIntent = Intent(this, MainActivity::class.java)
            notificationIntent.action = Constants.ACTION.MAIN_ACTION
            notificationIntent.flags = (Intent.FLAG_ACTIVITY_NEW_TASK
                    or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            val pendingIntent = PendingIntent.getActivity(
                this, 0,
                notificationIntent, 0
            )
            val previousIntent = Intent(this, ForegroundService::class.java)
            previousIntent.action = Constants.ACTION.PREV_ACTION
            val ppreviousIntent = PendingIntent.getService(
                this, 0,
                previousIntent, 0
            )
            val playIntent = Intent(this, ForegroundService::class.java)
            playIntent.action = Constants.ACTION.PLAY_ACTION
            val pplayIntent = PendingIntent.getService(
                this, 0,
                playIntent, 0
            )
            val nextIntent = Intent(this, ForegroundService::class.java)
            nextIntent.action = Constants.ACTION.NEXT_ACTION
            val pnextIntent = PendingIntent.getService(
                this, 0,
                nextIntent, 0
            )
            val icon = BitmapFactory.decodeResource(
                resources,
                R.drawable.ic_dialog_alert
            )
            val channelId =
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    createNotificationChannel("my_service", "My Background Service")
                } else {
                    // If earlier version channel ID is not used
                    // https://developer.android.com/reference/android/support/v4/app/NotificationCompat.Builder.html#NotificationCompat.Builder(android.content.Context)
                    ""
                }

            val notification: Notification = NotificationCompat.Builder(this)
                .setContentTitle("Truiton Music Player")
                .setTicker("Truiton Music Player")
                .setContentText("My Music")
                .setSmallIcon(R.mipmap.sym_def_app_icon)
                .setLargeIcon(
                    Bitmap.createScaledBitmap(icon, 128, 128, false)
                )
                .setContentIntent(pendingIntent)
                .setOngoing(true)
                .addAction(
                    R.drawable.ic_media_previous,
                    "Previous", ppreviousIntent
                )
                .addAction(
                    R.drawable.ic_media_play, "Play",
                    pplayIntent
                )
                .addAction(
                    R.drawable.ic_media_next, "Next",
                    pnextIntent
                ).setChannelId(channelId).build()



            startForeground(
                Constants.NOTIFICATION_ID.FOREGROUND_SERVICE,
                notification
            )
        } else if (intent.action == Constants.ACTION.PREV_ACTION) {
            Log.i(LOG_TAG, "Clicked Previous")
        } else if (intent.action == Constants.ACTION.PLAY_ACTION) {
            Log.i(LOG_TAG, "Clicked Play")
        } else if (intent.action == Constants.ACTION.NEXT_ACTION) {
            Log.i(LOG_TAG, "Clicked Next")
        } else if (intent.action ==
            Constants.ACTION.STOPFOREGROUND_ACTION
        ) {
            Log.i(LOG_TAG, "Received Stop Foreground Intent")
            stopForeground(true)
            stopSelf()
        }
        return START_STICKY
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun createNotificationChannel(channelId: String, channelName: String): String{
        val chan = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel(
                channelId,
                channelName, NotificationManager.IMPORTANCE_NONE
            )
        } else {
            TODO("VERSION.SDK_INT < O")
        }
        chan.lightColor = Color.BLUE
        chan.lockscreenVisibility = Notification.VISIBILITY_PRIVATE
        val service = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        service.createNotificationChannel(chan)
        return channelId
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(LOG_TAG, "In onDestroy")
    }

    override fun onBind(intent: Intent?): IBinder? {
        // Used only in case of bound services.
        return null
    }


}