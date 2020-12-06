package com.example.template

import android.app.PendingIntent
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import android.widget.SeekBar
import androidx.appcompat.app.ActionBar
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import kotlinx.android.synthetic.main.activity_songs_list.*
import kotlinx.android.synthetic.main.item_city.*
import kotlinx.android.synthetic.main.item_songs_list.*

class SongsListActivity : AppCompatActivity() {
    fun getIsPlaying() = mediaPlayer?.isPlaying == true
    var mediaPlayer = MediaPlayer()
    private lateinit var notificationManager: NotificationManagerCompat
    lateinit var runnable: Runnable
    private var handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_songs_list)


        notificationManager = NotificationManagerCompat.from(this)

        btn_list.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


        mediaPlayer = MediaPlayer.create(applicationContext, R.raw.maribou)
        sb_mediaPlay.progress = 0

        sb_mediaPlay.max = mediaPlayer.duration

        btn_play.setOnClickListener {
            val title = tv_title.text.toString()
            val playPauseIcon = if (getIsPlaying())
                R.drawable.ic_baseline_pause_24
            else
                R.drawable.ic_baseline_play_arrow_24
            val picture = BitmapFactory.decodeResource(resources, iv_cover.maxHeight)
            val pendingIntent = PendingIntent.getActivity(this, 0, intent, 0)
            val builder = NotificationCompat.Builder(this, SongNotification.CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_baseline_favorite_24)
                .setContentTitle(title)
                .setLargeIcon(picture)
                .setContentIntent(pendingIntent)
                .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
                .addAction(R.drawable.ic_baseline_fast_rewind_24, "Prev", null)
                .addAction(playPauseIcon, "play", null)
                .addAction(R.drawable.ic_baseline_fast_forward_24, "Next", null)
                .setColor(Color.BLACK)
                .setStyle(
                    androidx.media.app.NotificationCompat.MediaStyle()
                        .setShowActionsInCompactView(0, 1, 2)
                )

                .setPriority(NotificationCompat.PRIORITY_MAX)
                .setCategory(NotificationCompat.CATEGORY_SERVICE)
            val notification = builder.build()
            notificationManager.notify(1, notification)
            if (!mediaPlayer.isPlaying) {
                mediaPlayer.start()

                startService(Intent(this, SongService::class.java))

                btn_play.setImageResource(R.drawable.ic_baseline_pause_24)
            } else {


                stopService(Intent(this, SongService::class.java))
                mediaPlayer.pause()

                btn_play.setImageResource(R.drawable.ic_baseline_play_arrow_24)
            }
        }
        sb_mediaPlay.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, changed: Boolean) {
                if (changed) {
                    mediaPlayer.seekTo(progress)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })
        runnable = Runnable {
            sb_mediaPlay.progress = mediaPlayer.currentPosition
            handler.postDelayed(runnable, 1000)
        }
        handler.postDelayed(runnable, 1000)

        mediaPlayer.setOnCompletionListener {
            btn_play.setImageResource(R.drawable.ic_baseline_play_arrow_24)
            sb_mediaPlay.progress = 0
        }


        val intent = intent
        val song1 = intent.getStringExtra("name")
        val timer = intent.getStringExtra("time1")
        val dImageView = intent.getIntExtra("bImageView", 0)
        val artistNameee = intent.getStringExtra("artistNamee")

        tv_title.text = song1
        tv_timer.text = timer
        tv_ArtistName2.text = artistNameee
        iv_cover.setImageResource(dImageView)
    }

    private fun handlePLayPause() {
        if (mediaPlayer.isPlaying) {
            mediaPlayer.start()
        } else {
            mediaPlayer.stop()
        }    }
}