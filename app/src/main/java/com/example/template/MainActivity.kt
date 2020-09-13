package com.example.template

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val Cars = Task1()
        println(Cars.typeOfCar())
        println(Cars.buildYear())
        println(Cars.buildBy())
        println(Cars.dummyWrite())
    }
}