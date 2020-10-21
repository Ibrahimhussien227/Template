package com.example.template

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import kotlinx.android.synthetic.main.item_city.*
import kotlinx.android.synthetic.main.item_city.iv_city1

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val actionBar: ActionBar? = supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)
        actionBar.setDisplayShowHomeEnabled(true)

        val intent = intent
        val city1 = intent.getStringExtra("title")
        val dDecreption = intent.getStringExtra("bDescreption")
        val bImageView = intent.getIntExtra("imageview1", 0)

        actionBar.setTitle(city1)
        tv_city2.text = city1
        iv_city1.setImageResource(bImageView)
        tv_descreption.text = dDecreption
    }
}