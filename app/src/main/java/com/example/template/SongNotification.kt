package com.example.template

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build

class SongNotification : Application() {
    companion object {
        const val CHANNEL_ID = "channel1"
    }

    override fun onCreate() {
        super.onCreate()
        createNotification()
    }

    private fun createNotification() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel1 = NotificationChannel(
                CHANNEL_ID,
                "Music Channel",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            channel1.description = "Media Channel"

            val manager = getSystemService(NotificationManager::class.java)
            manager?.createNotificationChannel(channel1)

        }
    }
}