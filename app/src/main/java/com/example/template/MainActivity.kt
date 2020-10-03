package com.example.template

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_sign_up.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_Send.setOnClickListener {

            val intent = Intent(Intent.ACTION_SEND)
            intent.setType("text/plain")
            val editText = findViewById<EditText>(R.id.et_message)
            val message = et_message.text.toString()

            intent.putExtra(Intent.EXTRA_TEXT,message)

            if (intent.resolveActivity(packageManager) != null)

                startActivity(intent)

        }
        btn_secondAcitvity.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }
}