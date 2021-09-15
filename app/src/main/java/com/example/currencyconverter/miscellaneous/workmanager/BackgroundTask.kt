package com.example.currencyconverter.miscellaneous.workmanager

import android.R
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import androidx.annotation.NonNull
import androidx.core.app.NotificationCompat
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.currencyconverter.MainActivity


class BackgroundTask(context: Context,param:WorkerParameters):Worker(context,param) {
    @NonNull
    override fun doWork(): Result {
        Log.d("periodicWorkRequest", "Uploading photos in background")
        sendNotification("Background Task", "Succcessfully done")
        return Result.success()
    }

    fun sendNotification(title: String?, message: String?) {
        val mNotificationManager = applicationContext
            .getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                "1",
                "android",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            channel.description = "WorkManger"
            mNotificationManager.createNotificationChannel(channel)
        }
        val mBuilder: NotificationCompat.Builder =
            NotificationCompat.Builder(applicationContext, "1")
                .setSmallIcon(R.mipmap.sym_def_app_icon) // notification icon
                .setContentTitle(title) // title for notification
                .setContentText(message) // message for notification
                .setAutoCancel(true) // clear notification after click
        val intent = Intent(
            applicationContext,
            MainActivity::class.java
        )
        val pi = PendingIntent.getActivity(
            applicationContext,
            0,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT
        )
        mBuilder.setContentIntent(pi)
        mNotificationManager.notify(0, mBuilder.build())
    }
}
