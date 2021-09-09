package com.example.currencyconverter.serviceexample

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import java.util.*

class BoundService: Service() {

    var iBinder = MyBinder()

    override fun onBind(intent: Intent?): IBinder? {
        return iBinder
    }

    override fun onUnbind(intent: Intent?): Boolean {
        return super.onUnbind(intent)
    }

    fun randomNumber(): Int {
        var random = Random()

        return random.nextInt()

    }

    inner class MyBinder: Binder() {
        fun getService(): BoundService {
            return this@BoundService
        }
    }


}