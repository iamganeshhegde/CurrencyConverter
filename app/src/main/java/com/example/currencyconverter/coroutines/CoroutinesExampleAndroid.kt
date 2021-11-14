package com.example.currencyconverter.coroutines

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.currencyconverter.R
import kotlinx.android.synthetic.main.activity_coroutnes_example.*
import kotlinx.android.synthetic.main.activity_thread_learning.*
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main

class CoroutinesExampleAndroid:AppCompatActivity() {

    private val RESULT_1 = "RESULT_1"
    private val RESULT_2 = "RESULT_2"

    private val parentJob = Job()
    var coroutine =  CoroutineScope(Dispatchers.Main)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_coroutnes_example)


        btnShow.setOnClickListener {

            CoroutineScope(IO).launch {
                fakeRequest1()
            }
        }
    }

    suspend fun fakeRequest1() {
        var result1 = getResult1FromApi()
        println("Debug: ${result1}, : ${Thread.currentThread().name}")

        setTextOnMainThread(result1)


        val result2 = getResult2FromApi()
        println("Debug: ${result1}, : ${Thread.currentThread().name}")

        setTextOnMainThread(result2)

    }

    private suspend fun setTextOnMainThread(result1: String) {

        withContext(Main) {
            setTextOfTextView(result1)
        }

    }

    private fun setTextOfTextView(result1: String) {
        var text = coroutineText.text.toString()+" \n $result1"
        coroutineText.text = text
    }

    suspend fun getResult1FromApi(): String {

        logThread("getResultFromApi 1")
        delay(2_000)
        return RESULT_1
    }

    suspend fun getResult2FromApi(): String {

        logThread("getResultFromApi 2")
        delay(2_000)
        return RESULT_2
    }

    private fun logThread(methodName: String) {
        Log.d("TAG", "logThread: ${methodName}, : ${Thread.currentThread().name}")
        println("Debug: ${methodName}, : ${Thread.currentThread().name}")
    }
}