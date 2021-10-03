package com.example.currencyconverter.miscellaneous.thread

import android.os.Handler
import android.os.Looper
import android.util.Log

private const val ETAG = "ExampleLooperThread"
class ExampleLooperThread: Thread(ETAG) {
//    lateinit var handler:Handler
    lateinit var handler:ExampleHandler
    lateinit var looper: Looper

    override fun run() {
        Looper.prepare()

        looper = Looper.myLooper()!!

        handler = ExampleHandler()

        Looper.loop()
       /* for (i in 0 until 5) {
            Log.d(TAG, "run: $i")

            Thread.sleep(1000)
        }*/

        Log.d(TAG, "run: End of run")
    }
}