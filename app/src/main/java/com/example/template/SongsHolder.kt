package com.example.template

import android.os.Build
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.item_city.view.*
import kotlinx.android.synthetic.main.item_songs_list.view.*

class SongsHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bindItems(song: SongModel) {
        itemView.tvArtistName.text = song.songArtist
        itemView.iv_song1.setImageResource(song.imageResource)
        itemView.tv_song.text = song.songName
        itemView.tv_time.text = song.songDuration.toString()
    }
}