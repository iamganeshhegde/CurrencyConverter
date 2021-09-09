package com.example.currencyconverter.serviceexample

import android.R
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Intent
import android.media.MediaRecorder
import android.os.Binder
import android.os.Build
import android.os.CountDownTimer
import android.os.IBinder
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat.getSystemService
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import java.io.IOException
import java.nio.file.Files
import java.nio.file.LinkOption
import java.nio.file.Path
import java.util.*


class ServiceDemo : Service() {

    val fnlStr_debug_tag = "Service Demo Debug"
    var binder: IBinder? = null
    var allowRebind = false
    var stop_recording = false
    var thr_rmCache: Thread? = null
    var thr_recordSound:java.lang.Thread? = null

    override fun onCreate() {
        binder = LocalBinder()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if (intent == null) {
            /* The service has been killed , and the startMode
               has been set set to START_STICKY . As such
               the service is now being restarted , with a
               null Intent , so the original intent
               is not delivered again .
               When START_STICKY is set , the intent
               itself is not primordial , for the
               service to run .*/
            thr_rmCache = Thread(Purge_Cache(startId))
            thr_rmCache!!.run()
            return START_STICKY
        } else {
            /*An intent has been delivered . Either , the service
              is starting fresh , or it has been killed  , and
              its start mode has been set to START_REDELIVER_INTENT .
              So the original intent is being redelivered .*/
            when (intent.getStringExtra("do")) {
                "Clear Cache" -> if (thr_rmCache == null) {
                    thr_rmCache = Thread(Purge_Cache(startId))
                    thr_rmCache!!.run()
                    return START_STICKY
                }
                "Record Sound" -> if (thr_recordSound == null) {
                    thr_recordSound = Thread(Record_Sound())
                    thr_recordSound!!.run()
                    return START_REDELIVER_INTENT
                }
            }
        }
        return START_NOT_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? {
        /* extras are not delivered
           on binding , unbinding , or
           rebinding  .
           The intent delivered ,
           on binding , unbinding ,
           rebiding , is the original
           intent delivered when
           binding .*/
        return binder
    }

    override fun onUnbind(intent: Intent?): Boolean {
        return allowRebind
    }

    override fun onRebind(intent: Intent?) {}

    override fun onDestroy() {
        if (thr_rmCache != null && thr_rmCache!!.isAlive) thr_rmCache!!.interrupt()
        if (thr_recordSound != null) stop_recording = true
    }


    /* A class to Purge the cache directory  ,
      * it will show a toast when starting ,
      * the process , and when it is done
      * doing its job , it will show a
      * notification , and send a local
      * broadcast .*/
    inner class Purge_Cache(var startId: Int) : Runnable {
        @RequiresApi(Build.VERSION_CODES.O)
        override fun run() {
            //show a toast on start
            Toast.makeText(
                this@ServiceDemo,
                "Clearing the cache directory", Toast.LENGTH_LONG
            ).show()

            //purge the cache
            purge_Cache(getCacheDir().toPath())

            //show a notification after cash is purged
            cleared_Cache_Notification()

            //Create a local broadcast
            val intent = Intent("Cache Purged")
            intent.putExtra("msg", "The cache is purged")
            LocalBroadcastManager.getInstance(this@ServiceDemo.getApplicationContext())
                .sendBroadcast(intent)

            //done
            thr_rmCache = null
            if (thr_recordSound == null) stopSelf(startId)
        }

        @RequiresApi(Build.VERSION_CODES.O)
        fun purge_Cache(pathD: Path) {
            //Do not remove the directory , only its content recursively
            Log.d(fnlStr_debug_tag, pathD.toString())
            if (Thread.interrupted()) {
                return
            }
            try {
                Files.newDirectoryStream(pathD).use { paths ->
                    for (td_path in paths) {
                        Log.d(fnlStr_debug_tag, td_path.toString())
                        if (Files.isDirectory(td_path, LinkOption.NOFOLLOW_LINKS)) {
                            purge_Cache(td_path)
                        }
                        Files.delete(td_path)
                    }
                }
            } catch (exception: IOException) {
                Log.d(fnlStr_debug_tag, exception.toString())
            } catch (exception: SecurityException) {
                Log.d(fnlStr_debug_tag, exception.toString())
            }
        }

        @RequiresApi(Build.VERSION_CODES.O)
        fun cleared_Cache_Notification() {
            //Create notification channel
            val notification_channel_id = "coding_demo_cache_purged"
            val channel = NotificationChannel(
                notification_channel_id,
                "coding demo cache purged", NotificationManager.IMPORTANCE_DEFAULT
            )
            channel.description = "Coding demo cache purged channel"
            val notificationManager: NotificationManager = getSystemService<NotificationManager>(
                NotificationManager::class.java
            )!!
            notificationManager.createNotificationChannel(channel)

            //create notification
            val notification_id = 1
            val notification_builder: Notification.Builder =
                Notification.Builder(this@ServiceDemo, notification_channel_id)
                    .setSmallIcon(R.mipmap.sym_def_app_icon)
                    .setContentTitle("Code demo")
                    .setContentText("The application cache is cleared")
            notificationManager.notify(notification_id, notification_builder.build())
        }
    }


    /* Record sound class
     */
    inner class Record_Sound : Runnable {
        var audioCapture_countDownTimer: CountDownTimer? = null
        var audioCapture_recorder: MediaRecorder? = null
        var audioCapture_duration = 25
        @RequiresApi(Build.VERSION_CODES.O)
        override fun run() {
            Toast.makeText(
                this@ServiceDemo, "Starting to record Sound !",
                Toast.LENGTH_SHORT
            ).show()
            start_Recording()
            startForeground(2, sound_Recording_Notification())
        }

        fun start_Recording() {
            try {
                //Start recording
                val audioCapture_fileName: String = getCacheDir().getAbsoluteFile()
                    .toString() + "/" + UUID.randomUUID().toString() + ".m4a"
                audioCapture_recorder = MediaRecorder()
                audioCapture_recorder!!.setAudioSource(MediaRecorder.AudioSource.MIC)
                audioCapture_recorder!!.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4)
                audioCapture_recorder!!.setAudioEncoder(MediaRecorder.AudioEncoder.AAC)
                audioCapture_recorder!!.setAudioSamplingRate(44100)
                audioCapture_recorder!!.setAudioChannels(2)
                audioCapture_recorder!!.setAudioEncodingBitRate(32000)
                audioCapture_recorder!!.setOutputFile(audioCapture_fileName)
                audioCapture_recorder!!.prepare()
                audioCapture_recorder!!.start()


                //Cancel recording after audioCapture_duration , or on interrupt
                audioCapture_countDownTimer =
                    object : CountDownTimer((audioCapture_duration * 1000).toLong(), 1000) {
                        override fun onTick(millisUntilFinished: Long) {
                            if (stop_recording) {
                                audioCapture_countDownTimer!!.cancel()
                                stop_Recording()
                            }
                        }

                        override fun onFinish() {
                            Toast.makeText(
                                this@ServiceDemo,
                                "Finished recording audio", Toast.LENGTH_SHORT
                            ).show()
                            stop_Recording()
                        }
                    }
                (audioCapture_countDownTimer as CountDownTimer).start()
            } catch (exception: Exception) {
                Log.d(fnlStr_debug_tag, exception.toString())
                Toast.makeText(
                    this@ServiceDemo, "Failed to record sound ", Toast.LENGTH_SHORT
                )
            }
        }

        fun stop_Recording() {
            audioCapture_recorder!!.stop()
            audioCapture_recorder!!.release()
            thr_recordSound = null
            stop_recording = false
            stopForeground(true)
        }

        @RequiresApi(Build.VERSION_CODES.O)
        fun sound_Recording_Notification(): Notification {
            // Create notification channel
            val notification_channel_id = "coding_demo_audio_capture"
            val channel = NotificationChannel(
                notification_channel_id, "coding demo audio capture",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            channel.description = "Coding demo audio capture channel"
            val notificationManager: NotificationManager = getSystemService<NotificationManager>(
                NotificationManager::class.java
            )!!
            notificationManager.createNotificationChannel(channel)

            // Create the notification
            val notification_builder: Notification.Builder =
                Notification.Builder(this@ServiceDemo, notification_channel_id)
                    .setSmallIcon(R.mipmap.sym_def_app_icon)
                    .setContentTitle("Code demo")
                    .setContentText("Sound is being recorded")
            return notification_builder.build()
        }
    }

    inner class LocalBinder : Binder() {
        fun add(vararg vars_i: Int): Int {
            var sum = 0
            for (var_i in vars_i) {
                sum += var_i
            }
            return sum
        }

        fun stopRecordSound() {
            if (thr_recordSound != null) {
                stop_recording = true
                Log.d(fnlStr_debug_tag, "Audio recording is stopped ")
            }
        }
    }

}