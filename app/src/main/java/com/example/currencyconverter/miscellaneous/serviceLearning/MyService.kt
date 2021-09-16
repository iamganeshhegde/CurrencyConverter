package com.example.currencyconverter.miscellaneous.serviceLearning

import android.app.IntentService
import android.content.Intent
import android.os.SystemClock
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.example.currencyconverter.MainActivity

class MyService: IntentService("MyService") {
    override fun onHandleIntent(intent: Intent?) {
        var message = intent?.getStringExtra("message")
//        intent?.action = ServicetestActivity.FILTER_ACTION_KEY

        SystemClock.sleep(3000)

        var echo = "Intent service after 3 seconds $message"

        intent?.let { LocalBroadcastManager.getInstance(applicationContext).sendBroadcast(it.putExtra("broadcastMessage",echo)) }

    }
}