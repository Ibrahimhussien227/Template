package com.example.template


import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_profile.*
import kotlinx.android.synthetic.main.activity_sign_up.*


class SignUp : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)


        val sharedPreferences = getSharedPreferences("Admin", Context.MODE_PRIVATE)

        btn_signUp.setOnClickListener {
            val userName = et_signUpUserName.editText?.text.toString()
            val email = et_signUpEmail.editText?.text.toString()
            val fullName = et_signUpFullName.editText?.text.toString()
            val city = et_signUpCity.editText?.text.toString()
            val phone  = et_signUpPhone.editText?.text.toString()
            val password = et_signUpPassword.editText?.text.toString()


            val editor = sharedPreferences.edit()
            editor.putString("USERNAME", userName)
            editor.putString("EMAIL", email)
            editor.putString("FULL NAME", fullName)
            editor.putString("CITY", city)
            editor.putString("PHONE", phone)
            editor.putString("PASSWORD", password)
            editor.apply()

            val intent = Intent(this, Profile::class.java)
            startActivity(intent)
        }
    }
}