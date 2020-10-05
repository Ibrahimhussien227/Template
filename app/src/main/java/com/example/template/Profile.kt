package com.example.template

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_profile.*


class Profile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)


        val sharedPreferences = getSharedPreferences("Admin", Context.MODE_PRIVATE)
        val userName = sharedPreferences.getString("USERNAME", "")
        tvUserName.text = userName
        et_profileUserName.setText(userName)
        val email = sharedPreferences.getString("EMAIL", "")
        et_profileEmail.setText(email)
        val fullName = sharedPreferences.getString("FULL NAME", "")
        et_profileFullName.setText(fullName)
        tvName.text = fullName
        val city = sharedPreferences.getString("CITY", "")
        et_profileCity.setText(city)
        val phone = sharedPreferences.getString("PHONE", "")
        et_profilePhone.setText(phone)
        val password = sharedPreferences.getString("PASSWORD", "")
        et_profilePassword.setText(password)


        Toast.makeText(this, "Welcome", Toast.LENGTH_LONG).show()


        btn_profileLogOut.setOnClickListener {
            val intent = Intent(this, SignUp::class.java)
            startActivity(intent)
        }
    }
}