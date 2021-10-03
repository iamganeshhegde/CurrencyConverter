package com.example.currencyconverter.miscellaneous.thread

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import androidx.appcompat.app.AppCompatActivity
import com.example.currencyconverter.R
import kotlinx.android.synthetic.main.activity_thread_learning.*

class ThreadLearning : AppCompatActivity() {

//    private lateinit var worker: SimpleWorker
    private lateinit var worker: Worker
    private var handler = object : Handler(Looper.getMainLooper()) {
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            textViewMessage.text = msg.obj.toString()
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_thread_learning)
//        worker = SimpleWorker()
        worker = Worker()

        worker.execute {
            Thread.sleep(1000)
            var message = Message.obtain()
            message.obj = "Task1"
            handler.sendMessage(message)
        }.execute {
            Thread.sleep(2000)
            var message = Message.obtain()
            message.obj = "Task2"
            handler.sendMessage(message)
        }.execute {
            Thread.sleep(1000)
            var message = Message.obtain()
            message.obj = "Task3"
            handler.sendMessage(message)
        }




    }

    override fun onDestroy() {
        super.onDestroy()
        worker.quit()
    }
}