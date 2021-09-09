package com.example.currencyconverter.serviceexample

import android.app.Service
import android.content.Intent
import android.content.ServiceConnection
import android.media.MediaPlayer
import android.os.IBinder
import android.provider.Settings
import java.util.concurrent.Executor

class ServiceWithoutBinder: Service() {

    private lateinit var player:MediaPlayer


    override fun onBind(intent: Intent?): IBinder? {

        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        player = MediaPlayer.create(this,Settings.System.DEFAULT_RINGTONE_URI)

        player.isLooping = true

        player.start()

        return START_STICKY

    }

    override fun onDestroy() {
        super.onDestroy()
        if(this::player.isInitialized) {
            player.stop()
        }

    }

    override fun bindService(service: Intent?, conn: ServiceConnection, flags: Int): Boolean {
        return super.bindService(service, conn, flags)
    }

    override fun bindService(
        service: Intent,
        flags: Int,
        executor: Executor,
        conn: ServiceConnection
    ): Boolean {
        return super.bindService(service, flags, executor, conn)
    }
}