package com.example.template


import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.time.Duration

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val songList: List<SongModel> = arrayListOf(
            SongModel(R.drawable.lovely, R.raw.maribou, "Maribou", 3, "Billie Eilish"),
            SongModel(R.drawable.cover_2, R.raw.rise, "Rise", 2, "Andra Day"),
            SongModel(R.drawable.cover_3, R.raw.i_am_king,"I Am King", 4, "James Meyers"),
            SongModel(R.drawable.cover_4, R.raw.davidguetta,"play",2, "David Guetta"),
            SongModel(R.drawable.cover_5, R.raw.in_the_end, "In The End", 3, "Linkin Park"),
            SongModel(R.drawable.cover_6, R.raw.hislerim, "Hislerim", 2, "Serhat Dermus"),
            SongModel(R.drawable.cover_7, R.raw.the_irrepressibles, "In This Shirt", 4, "Irrepressibles")

        )

        val songAdapter = SongListAdapter(songList, this)



        rv_songs.layoutManager = LinearLayoutManager(this)
        rv_songs.adapter = songAdapter
        rv_songs.setHasFixedSize(true)

    }
}