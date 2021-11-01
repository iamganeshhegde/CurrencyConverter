package com.example.currencyconverter.miscellaneous.thread

import android.os.*
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.postAtTime
import com.example.currencyconverter.R

private const val TAGGG = "HandlerThread"
class ExampleHandlerThread:AppCompatActivity() {

//    private var handlerThread = HandlerThread(TAGGG)
    private var handlerThread = ExampleHandlerThreadThread()
    var runnable1 = ExampleRunnable1()
    var token = Object()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_handler_thread_example)

        handlerThread.start()
//        threadHandler = Handler(handlerThread.looper)
    }

    fun doWork(view: View) {
//        threadHandler.postDelayed(ExampleRunnable1(),2000)

//        handlerThread.handler.post(ExampleRunnable1())
//        handlerThread.handler.post(ExampleRunnable1())
//        handlerThread.handler.postAtFrontOfQueue(ExampleRunnable2())

        var message = Message.obtain()

        message.what = 1
        message.what = 2
        message.what = 3

        message.obj = 23
        handlerThread.handler.sendMessage(message)


        //handlerThread.handler.sendEmptyMessage(1)
//        handlerThread.handler.post(ExampleRunnable1())
        handlerThread.handler.postAtTime(runnable1,token,SystemClock.uptimeMillis())
        handlerThread.handler.post(runnable1)


    }
    fun removeMessages(view: View) {

//        handlerThread.handler.removeCallbacksAndMessages(null)
//        handlerThread.handler.removeCallbacksAndMessages(runnable1)
        handlerThread.handler.removeCallbacks(runnable1, token)

    }

    override fun onDestroy() {
        super.onDestroy()

        handlerThread.quit()
    }

    companion object{
        class ExampleRunnable1:Runnable{
            override fun run() {

                for(i in 0 until 5) {
                    Log.d(TAG, "run1: $i")
                    Thread.sleep(1000)
                }

            }

        }

        class ExampleRunnable2:Runnable{
            override fun run() {

                for(i in 0 until 5) {
                    Log.d(TAG, "run2: $i")
                    Thread.sleep(1000)
                }

            }

        }
    }

}
