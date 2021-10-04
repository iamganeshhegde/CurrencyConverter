package com.example.currencyconverter.miscellaneous.thread

import android.os.Handler
import android.os.HandlerThread
import android.os.Message
import android.os.Process
import android.util.Log

private const val TAGS = "ExampleHandlerThreadThr"
class ExampleHandlerThreadThread:HandlerThread(TAGS, Process.THREAD_PRIORITY_BACKGROUND) {

    lateinit var handler:Handler

    override fun onLooperPrepared() {
        handler = object : Handler() {

            override fun handleMessage(msg: Message) {
                when(msg.what) {
                    1 -> {
                        Log.d(TAG, "handleMessage: what "+msg.what)
                        Log.d(TAG, "handleMessage: object "+msg.obj)
                    }
                    2 -> {
                        Log.d(TAG, "handleMessage: "+msg.what)
                        Log.d(TAG, "handleMessage: object "+msg.obj)

                    }
                    3 -> {

                        for(i in 0 until 5 ){
                            Log.d(TAG, "handleMessage: "+msg.what)
                            Log.d(TAG, "handleMessage: object "+msg.obj)
                            Thread.sleep(1000)
                        }

                    }
                }
            }
        }
    }

    @JvmName("getHandler1")
    fun getHandler(): Handler {
        return handler
    }



}