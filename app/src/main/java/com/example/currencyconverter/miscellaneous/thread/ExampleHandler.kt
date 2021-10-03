package com.example.currencyconverter.miscellaneous.thread

import android.os.Handler
import android.os.Message
import android.util.Log

const val TAK_A = 1

const val TAK_B = 2

class ExampleHandler: Handler() {
    private val TAG = "ExampleHandler"


    override fun handleMessage(msg: Message) {

        when(msg.what) {
            TAK_A -> Log.d(TAG, "handleMessage: Task A executed")
            TAK_B -> Log.d(TAG, "handleMessage: Task B executed")
        }

    }
}