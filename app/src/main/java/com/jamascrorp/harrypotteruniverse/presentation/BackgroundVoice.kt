package com.jamascrorp.harrypotteruniverse.presentation

import android.app.Service
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import com.jamascrorp.harrypotteruniverse.R

class BackgroundVoice : Service() {

    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate() {
        super.onCreate()
        mediaPlayer = MediaPlayer.create(this, R.raw.voice)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        mediaPlayer.isLooping = true
        mediaPlayer.start()

        return START_NOT_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.stop()
    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    companion object {

        fun intent(context: Context): Intent {
            return Intent(context, BackgroundVoice::class.java)
        }
    }
}
