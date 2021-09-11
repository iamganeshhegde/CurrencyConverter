package com.example.currencyconverter.serviceexample

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Binder
import android.os.Build
import android.os.Handler
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.lifecycle.MutableLiveData
import java.util.*

class MyBoundService:Service() {

    private val mBinder: IBinder = MyBinder()

    // Random number generator
    private val mGenerator: Random = Random()

    // LiveData for capturing random number generated by the service
    val randomNumberLiveData: MutableLiveData<Int> = MutableLiveData()

    // Channel ID for notification
    val CHANNEL_ID = "Random number notification"

    /**
     * Class used for the client Binder. The Binder object is responsible for returning an instance
     * of "MyService" to the client.
     */
    inner class MyBinder : Binder() {
        // Return this instance of MyService so clients can call public methods
        val service: MyBoundService
            get() =// Return this instance of MyService so clients can call public methods
                this@MyBoundService
    }

    /**
     * This is how the client gets the IBinder object from the service. It's retrieve by the "ServiceConnection"
     * which you'll see later.
     */
    override fun onBind(intent: Intent): IBinder? {
        return mBinder
    }

    /**
     * Called when service is created So  we will do our work here
     */
    override fun onCreate() {
        super.onCreate()
        Log.d("MyBoundService", "onCreate called")
        startNotification()

        Handler().postDelayed({
            val randomNumber = mGenerator.nextInt(100)
            randomNumberLiveData.postValue(randomNumber)
        }, 1000)
    }

    /**
     * Used for creating and starting notification
     * whenever we start our Bound service
     */
    private fun startNotification() {
        val channel = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel(
                CHANNEL_ID,
                "My Channel",
                NotificationManager.IMPORTANCE_DEFAULT
            )
        } else {
            TODO("VERSION.SDK_INT < O")
        }
        (getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager).createNotificationChannel(channel)
        val notification: Notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("A service is running in the background")
            .setContentText("Generating random number").build()
        startForeground(1, notification)
    }
}