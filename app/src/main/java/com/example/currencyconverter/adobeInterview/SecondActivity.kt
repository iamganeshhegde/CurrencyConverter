package com.example.currencyconverter.adobeInterview

import android.content.Intent
import android.media.AudioManager
import android.media.MediaPlayer
import android.os.Bundle
import android.provider.AlarmClock
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


        //check

//        var intent = Intent(Intent.ACTION_SYNC,null,this,DownloadSe)

//        var intent = Intent(AlarmClock.ACTION_SET_ALARM)
//            .

        var mediaPlayer = MediaPlayer();

        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC)

//        mediaPlayer.setDataSource(applicationContext,)

    }


    fun modify(name:String) = {
        from:Int, to:Int -> {
            type:Boolean -> name.substring(from, to).let { if(type) it.uppercase() else it.lowercase() }
    }
    }

    fun toString(x:Any) :String {
        return when(x) {
            is Int -> x.div(3).toString()
            is String ->x.toLowerCase()
            is Long -> x.toInt().toString()
            else ->"Invalid"
        }
    }
    fun main() {
        println(modify("caca")(1,2)(true))
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