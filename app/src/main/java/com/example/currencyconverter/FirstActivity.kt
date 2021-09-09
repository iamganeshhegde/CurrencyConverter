package com.example.currencyconverter

import android.Manifest
import android.content.*
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.IBinder
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.example.currencyconverter.serviceexample.BoundService
import com.example.currencyconverter.serviceexample.ServiceDemo
import com.example.currencyconverter.serviceexample.ServiceWithoutBinder
import kotlinx.android.synthetic.main.activity_first.*


class FirstActivity: AppCompatActivity() {


    var boundService :BoundService? = null
    var isBound = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_first)
    }


    override fun onStart() {
        super.onStart()

        var intent = Intent(this, BoundService::class.java)

        startService(intent)
        bindService(intent,boundServiceConnection, BIND_AUTO_CREATE)
    }


    override fun onResume() {
        super.onResume()

        var runnable = Runnable {
            Toast.makeText(this, boundService?.randomNumber()!!,Toast.LENGTH_LONG).show()
        }

        var handler = Handler()
        handler.postDelayed(runnable,3000)

    }

    var boundServiceConnection:ServiceConnection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            var binderBridge = service as BoundService.MyBinder

            boundService = binderBridge.getService()
            isBound = true

        }

        override fun onServiceDisconnected(name: ComponentName?) {

            isBound = false
            boundService = null
        }
    }



}


//Testing service with record audio

//
//    val fnlStr_debug_tag = "Activity Main Debug"
//    val fnlInt_request_audio_permissions = 1013
//    val arr_btnModels = arrayOf(
//        Button_Model(Button_Model.fnlStr_code_notification),
//        Button_Model(Button_Model.fnlStr_code_noNotification),
//        Button_Model(Button_Model.fnlStr_codeBound_notification_noNotification)
//    )
//
//
//    fun create_Interface() {
//        val ll = LinearLayout(this)
//        ll.orientation = LinearLayout.VERTICAL
//        val click_listener_buttons = Click_Listener_Buttons()
//        var btn: Button
//        for (btnModel in arr_btnModels) {
//            btn = Button(this)
//            btn.text = btnModel.btn_text
//            btn.tag = btnModel.btn_text
//            btn.setOnClickListener(click_listener_buttons)
//            ll.addView(
//                btn,
//                ViewGroup.LayoutParams.MATCH_PARENT,
//                ViewGroup.LayoutParams.WRAP_CONTENT
//            )
//        }
//        setContentView(ll)
//    }
//
//    fun register_Broadcast_Receiver() {
//        val cachePurged_receiver = CachePurged_Receiver()
//        val intentFilter = IntentFilter("Cache Purged")
//        LocalBroadcastManager.getInstance(applicationContext)
//            .registerReceiver(cachePurged_receiver, intentFilter)
//    }
//
//
//    inner class CachePurged_Receiver : BroadcastReceiver() {
//        override fun onReceive(context: Context?, intent: Intent) {
//            Log.d(fnlStr_debug_tag, "Cache Purged Broadcast Received")
//            Toast.makeText(
//                context, intent.getStringExtra("msg"),
//                Toast.LENGTH_LONG
//            ).show()
//        }
//    }
//
//    inner class Click_Listener_Buttons : View.OnClickListener {
//        var localBinder: ServiceDemo.LocalBinder? = null
//        var service_connection: Service_Connection? = null
//        @RequiresApi(Build.VERSION_CODES.M)
//        override fun onClick(view: View) {
//            val intent = Intent(this@FirstActivity, ServiceDemo::class.java)
//            when (view.tag as String) {
//                Button_Model.fnlStr_code_noNotification -> {
//                    Log.d(fnlStr_debug_tag, "running some code without a notification")
//                    //start service purge cache
//                    intent.putExtra("do", "Clear Cache")
//                    startService(intent)
//                }
//                Button_Model.fnlStr_code_notification -> {
//                    Log.d(fnlStr_debug_tag, "running some code showing a notification")
//                    //check for permissions
//                    if (checkSelfPermission(Manifest.permission.RECORD_AUDIO) == PackageManager.PERMISSION_GRANTED) {
//                        // granted start audio recording service
//                        intent.putExtra("do", "Record Sound")
//                        startService(intent)
//                    } else {
//                        // not granted , request the permissions
//                        requestPermissions(
//                            arrayOf<String>(Manifest.permission.RECORD_AUDIO),
//                            fnlInt_request_audio_permissions
//                        )
//                    }
//                }
//                Button_Model.fnlStr_codeBound_notification_noNotification -> {
//                    /* Click the third button , which is this switch case ,
//                       only after starting an audio recording service ,
//                       since it will automatically stop it ,
//                       If you click it a second time , it is not necessary ,
//                       to start recording , it will just unding the service . */Log.d(
//                        fnlStr_debug_tag,
//                        "Bound code interacting with code showing and not showing a notification"
//                    )
//                    if (service_connection != null) {
//                        unbindService(service_connection!!)
//                        service_connection = null
//                    } else {
//                        service_connection = Service_Connection()
//                        bindService(intent, service_connection!!, BIND_AUTO_CREATE)
//                    }
//                }
//            }
//        }
//
//        inner class Service_Connection : ServiceConnection {
//            override fun onServiceConnected(name: ComponentName, service: IBinder) {
//                // Called when binding has been established .
//                localBinder = service as ServiceDemo.LocalBinder
//                Log.d(fnlStr_debug_tag, "" + localBinder!!.add(1, 2, 3, 4))
//                // call the add method in the bound service .
//                localBinder!!.stopRecordSound()
//                /* Stop sound recording in the bound service */
//            }
//
//            override fun onServiceDisconnected(name: ComponentName) {
//                //Called when binding is lost .
//                localBinder = null
//            }
//
//            override fun onBindingDied(name: ComponentName) {
//                // Called when  binding is dead.
//                localBinder = null
//            }
//
//            override fun onNullBinding(name: ComponentName) {
//                // Called when onBind returns null
//                localBinder = null
//            }
//        }
//    }
//
//
//    override fun onRequestPermissionsResult(
//        requestCode: Int,
//        permissions: Array<out String>,
//        grantResults: IntArray
//    ) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
//
//        when (requestCode) {
//            fnlInt_request_audio_permissions -> if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                //audio record permission has been granted
//                val intent = Intent(this@FirstActivity, ServiceDemo::class.java)
//                intent.putExtra("do", "Record Sound")
//                startService(intent)
//            } else {
//                Log.d(fnlStr_debug_tag, "Permission to record sound not granted")
//            }
//        }
//    }
//
//
//
//
//
//
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        create_Interface ( );
//        register_Broadcast_Receiver ( );
//
////        setContentView(R.layout.activity_first)
////
////
////        startService.setOnClickListener {
////            startService(Intent(this, ServiceWithoutBinder::class.java))
////        }
////
////
////        stopService.setOnClickListener {
////            stopService(Intent(this, ServiceWithoutBinder::class.java))
////        }
//    }
//}
//
//class Button_Model(var btn_text: String) {
//    companion object {
//        const val fnlStr_code_noNotification = "Code no notification Service"
//        const val fnlStr_code_notification = "Code notification Service"
//        const val fnlStr_codeBound_notification_noNotification =
//            "Code bound notification and no notification Service"
//    }
//}