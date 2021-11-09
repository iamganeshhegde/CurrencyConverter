package com.example.currencyconverter.intentservice

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.currencyconverter.R
import com.example.currencyconverter.miscellaneous.serviceLearning.MyService
import kotlinx.android.synthetic.main.activity_intent_service_broad_activity.*


class IntentServiceBroadActivity:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_intent_service_broad_activity)

        button.setOnClickListener(View.OnClickListener {
            val message: String = inputText.getText().toString()
            val intent = Intent(this@IntentServiceBroadActivity, MyService::class.java)
            intent.putExtra("message", message)
            startService(intent)
        })

    }
}