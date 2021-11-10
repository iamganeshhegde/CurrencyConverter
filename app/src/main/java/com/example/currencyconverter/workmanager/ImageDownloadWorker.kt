package com.example.currencyconverter.workmanager

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.BitmapFactory
import android.widget.RemoteViews
import androidx.core.app.NotificationCompat
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.currencyconverter.R
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.OkHttpClient
import okhttp3.Request
import org.greenrobot.eventbus.EventBus
import java.lang.Exception

class ImageDownloadWorker(conntext: Context, workParams: WorkerParameters) :
    Worker(conntext, workParams) {
    override fun doWork(): Result {
        val json = inputData.getString("images")

        val gson = Gson()

        val listOfImages =
            gson.fromJson<List<Image>>(json, object : TypeToken<List<Image>>() {}.type)

        listOfImages.forEachIndexed { index, image ->
            Thread.sleep(1000)
            downloadImage(image, index)
        }


        return Result.success()
    }

    private fun downloadImage(image: Image, index: Int) {

        val client = OkHttpClient()

        val request = Request.Builder()
            .url(image.url)
            .build()


        try {
            val response = client.newCall(request).execute()
            val bitmap = BitmapFactory.decodeStream(response.body?.byteStream())

            ImageUtil.saveBitmap(applicationContext, bitmap, image.title).subscribe({ img ->

                displayNotification(ProgressUpdateEvent(image.title, 3, index + 1))
                EventBus.getDefault().post(ImageDownloadedEvent(image, image.title, image.id))

            }, {

                    error ->
                error.printStackTrace()
            })

        } catch (e: Exception) {
            e.printStackTrace()
        }

    }
    private val notificationManager =
        applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager


    private val notificationId: Int = 500
    private val notificationChannel: String = "demo"

    private fun displayNotification(prog: ProgressUpdateEvent) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                notificationChannel,
                notificationChannel,
                NotificationManager.IMPORTANCE_DEFAULT
            )
            channel.enableVibration(false)
            notificationManager.createNotificationChannel(channel)
        }

        val notificationBuilder =
            NotificationCompat.Builder(applicationContext, notificationChannel)


        notificationBuilder
            .setContentText("texr")
            .setContentText("contenttext")

            .setSmallIcon(R.drawable.btn_main_round)

        notificationManager.notify(notificationId, notificationBuilder.build())
    }

    data class ProgressUpdateEvent(var message: String, var total: Int, var progress: Int)

    override fun onStopped() {
        super.onStopped()
        notificationManager.cancel(notificationId)
    }
}