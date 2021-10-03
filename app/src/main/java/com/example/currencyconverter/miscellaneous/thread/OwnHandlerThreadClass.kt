package com.example.currencyconverter.miscellaneous.thread

import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.currencyconverter.R

class OwnHandlerThreadClass:AppCompatActivity() {

    private val TAG = "OwnHandlerThreadClass"
    var looperThread:ExampleLooperThread = ExampleLooperThread()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_handler_thread_own)



    }

    fun startThread(view: View) {

        looperThread.start()
    }
    fun stopThread(view: View) {
        looperThread.looper.quit()
    }
    fun taskA(view: View) {
//        var handlerThread = Handler(looperThread.looper)
//        looperThread.handler.post {
//        handlerThread.post {
//            for(i in 0 until 5) {
//                Log.d(TAG, "taskA: $i")
//                Thread.sleep(1000)
//            }
//        }

        var message = Message.obtain()
        message.what = 1
        looperThread.handler.sendMessage(message)

    }
    fun taskB(view: View) {

        var message = Message.obtain()
        message.what = 2
        looperThread.handler.sendMessage(message)
    }
}