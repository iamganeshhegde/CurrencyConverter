package com.example.currencyconverter.miscellaneous.thread

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.currencyconverter.R
import kotlinx.android.synthetic.main.activity_looper_handler_thread.*

class LooperHandlerThread : AppCompatActivity() {

    private val TAG = "LooperHandlerThread"
    var handler = Handler()
    @Volatile var stop = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_looper_handler_thread)
    }

    fun startThread(view: View) {

        stop = false

//        var thread = ExampleThread(10)
//        thread.start()

        var runnable = ExampleRunnable(10)
        var thread = Thread(runnable)
        thread.start()

//        Thread(object : Runnable {
//            override fun run() {
//                //work
//            }
//        }).start()

    }

    fun stopThread(view: View) {
        stop = true
    }


    class ExampleThread(var seconds: Int) : Thread() {
        override fun run() {
            for (i in 0 until seconds) {
                Log.d(TAG, "startThread: $i")
                Thread.sleep(1000)
            }

        }
    }


    inner class ExampleRunnable(var seconds: Int) : Runnable {
        override fun run() {

            var threadHandler = Handler(Looper.getMainLooper())

            for (i in 0 until seconds) {
                if(stop) {
                    return
                }
                if (i == 5) {

//                    handler.post { button_start_thread.text = "50%" }
//                    threadHandler.post { button_start_thread.text = "50%" }

//                    runOnUiThread {
//                        button_start_thread.text = "50%"
//                    }

                    button_start_thread.post {
                        button_start_thread.text = "50%"
                    }


                }
                Log.d(TAG, "startThread: $i")
                Thread.sleep(1000)
            }

        }

    }

}