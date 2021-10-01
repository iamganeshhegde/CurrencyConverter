package com.example.currencyconverter.adobeInterview

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.currencyconverter.R


class SecondActivity:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i("Activty B", "onCreate")

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val fragmentManager: android.app.FragmentManager? = fragmentManager
        val fragmentTransaction: android.app.FragmentTransaction? = fragmentManager?.beginTransaction()
        val hello = SecondFragment()
        fragmentTransaction?.add(R.id.fragment_container, hello, "HELLO")
        fragmentTransaction?.commit()
    }

    override fun onStart() {
        Log.i("Activty B", "onStart")
        super.onStart()
    }

    override fun onRestart() {
        Log.i("Activty B", "onReStart")

        super.onRestart()
    }

    override fun onResume() {
        Log.i("Activty B", "onResume")

        super.onResume()
    }

    override fun onPause() {
        Log.i("Activty B", "onPause")

        super.onPause()
    }

    override fun onStop() {
        Log.i("Activty B", "onStop")

        super.onStop()
    }

    override fun onDestroy() {
        Log.i("Activty B", "onDestroy")

        super.onDestroy()
    }
}