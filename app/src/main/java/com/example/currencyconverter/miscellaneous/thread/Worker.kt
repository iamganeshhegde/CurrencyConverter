package com.example.currencyconverter.miscellaneous.thread

import android.os.Handler
import android.os.HandlerThread

var TAGG = "Worker"
class Worker: HandlerThread(TAGG) {

    lateinit var handler:Handler
    init {
        start()
        handler = Handler(looper)
    }


    fun execute(runnable: Runnable):Worker {

        handler.post(runnable)
        return this@Worker
    }
}