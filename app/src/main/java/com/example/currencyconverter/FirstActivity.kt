package com.example.currencyconverter

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.currencyconverter.serviceexample.ServiceWithoutBinder
import kotlinx.android.synthetic.main.activity_first.*

class FirstActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_first)


        startService.setOnClickListener {
            startService(Intent(this, ServiceWithoutBinder::class.java))
        }


        stopService.setOnClickListener {
            stopService(Intent(this, ServiceWithoutBinder::class.java))
        }
    }
}