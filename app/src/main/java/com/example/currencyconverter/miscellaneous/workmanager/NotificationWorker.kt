package com.example.currencyconverter.miscellaneous.workmanager

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.currencyconverter.R
import com.example.currencyconverter.b
import com.example.currencyconverter.miscellaneous.fragmentlearnings.FragmentFirstActivity

class NotificationWorker(context:Context, workerParams:WorkerParameters):Worker(context,workerParams) {

    private val WORK_RESULT = "work_result"

    override fun doWork(): Result {

        var dataString:String? = inputData.getString(FragmentFirstActivity.MESSAGE_STATUS)

        showNotification("WorkManager", dataString?:"Message has been sent")

        var outputData = Data.Builder().putString(WORK_RESULT,"Job Finished").build()

        return Result.success(outputData)
    }

    private fun showNotification(task: String, desc: String) {

        var manager = applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        var channelName = "task_name"
        var channelId = "task_channel"


        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            var channel = NotificationChannel(channelId,channelName,NotificationManager.IMPORTANCE_DEFAULT)

            manager.createNotificationChannel(channel)
        }

        var builder = NotificationCompat.Builder(applicationContext,channelId)
            .setContentTitle(task)
            .setContentText(desc)
            .setSmallIcon(R.mipmap.ic_launcher)


        manager.notify(1, builder.build())

    }


}