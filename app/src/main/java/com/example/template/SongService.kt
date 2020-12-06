package com.example.template

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import java.util.*
import javax.security.auth.callback.Callback

class SongService : Service() {

    private var mediaPlayer : MediaPlayer = MediaPlayer()
    private var callBack : Callback? = null
    private var timer : Timer? = null


    override fun onBind(intent: Intent?): IBinder? {
        TODO("Not yet implemented")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        mediaPlayer = MediaPlayer.create(this, R.raw.maribou)
        mediaPlayer.isLooping
        mediaPlayer.start()
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.stop()
    }
}