package com.example.currencyconverter.miscellaneous.serviceLearning

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.os.SystemClock
import android.util.Log
import android.widget.Chronometer

class BoundService : Service() {

    var mBinder = MyNewBinder()
    lateinit var chronometer:Chronometer

    override fun onBind(intent: Intent?): IBinder? {
        Log.v("Services", "in onBind");

        return mBinder
    }

    override fun onCreate() {
        Log.v("Services", "in onCreate");
        super.onCreate()
        chronometer = Chronometer(this)
        chronometer.base = SystemClock.elapsedRealtime()
        chronometer.start()
    }
    override fun onUnbind(intent: Intent?): Boolean {
        Log.v("Services", "in onUnbind")
        return true
    }

    override fun onDestroy() {
        Log.v("Services", "in onDestroy")

        super.onDestroy()
        chronometer.stop()
    }

    override fun onRebind(intent: Intent?) {
        Log.v("Services", "in onRebind")

        super.onRebind(intent)

    }


    fun getTimeStamp(): String {
        var elapsedMillis = SystemClock.elapsedRealtime() - chronometer.base

        val hours = (elapsedMillis / 3600000).toInt()
        val minutes = (elapsedMillis - hours * 3600000).toInt() / 60000
        val seconds = (elapsedMillis - hours * 3600000 - minutes * 60000).toInt() / 1000
        val millis = (elapsedMillis - hours * 3600000 - minutes * 60000 - seconds * 1000).toInt()
        return "$hours:$minutes:$seconds:$millis"
    }


    inner class MyNewBinder : Binder() {
        val service: BoundService
            get() = this@BoundService
    }
}