package com.example.template

import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RawRes
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_songs_list.*

class SongListAdapter(
    private val song: List<SongModel>,
    val context: Context
) : RecyclerView.Adapter<SongsHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongsHolder {
        val itemHolder =
            LayoutInflater.from(parent.context).inflate(R.layout.item_songs_list, parent, false)
        return SongsHolder(itemHolder)
    }

    override fun onBindViewHolder(holder: SongsHolder, position: Int) {
        holder.bindItems(song[position])
        holder.itemView.setOnClickListener {



            val song = song.get(position)
            val artistName: String = song.songArtist
            val text1: String = song.songName
            val time: Int = song.songDuration
            val iImageView: Int = song.imageResource

            val intent = Intent(context, SongsListActivity::class.java)

            intent.putExtra("artistNamee", artistName)
            intent.putExtra("name", text1)
            intent.putExtra("time1", time)
            intent.putExtra("bImageView", iImageView)

            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return song.size
    }
}


