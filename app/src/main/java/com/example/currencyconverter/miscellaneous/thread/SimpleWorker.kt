package com.example.currencyconverter.miscellaneous.thread

import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log
import java.util.concurrent.ConcurrentLinkedQueue
import java.util.concurrent.atomic.AtomicBoolean

var TAG = "SimpleWorker"

class SimpleWorker:Thread(TAG) {

    var alive:AtomicBoolean = AtomicBoolean(true)
    var taskQueue:ConcurrentLinkedQueue<Runnable> = ConcurrentLinkedQueue()

//    var hand = object : Handler() {
//        override fun handleMessage(msg: Message) {
//            super.handleMessage(msg)
//        }
//
//    }

//    var handler = Handler(Looper.getMainLooper())

    init {
        start()
    }

    override fun run() {

        while (alive.get()) {

            var task = taskQueue.poll()

            task?.run()
        }

        Log.i(TAG, "Simpleworker terminated")


    }


    fun execute(runnable:Runnable):SimpleWorker {
        taskQueue.add(runnable)
        return this@SimpleWorker
    }

    fun quit() {
        alive.set(false)
    }

}