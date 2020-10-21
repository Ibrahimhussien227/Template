package com.example.template


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val item = ArrayList<City>()

        item.add(City(R.drawable.russian, "RUSSIAN", "This is Russian Description"))
        item.add(City(R.drawable.egypt, "EGYPT", "This is Egypt Description"))
        item.add(City(R.drawable.france, "FRANCE", "This is France Description"))
        item.add(City(R.drawable.germany, "GERMANY", "This is German Description"))

        val cityAdapter = CityAdapter(item, this)

        rv_1.layoutManager = LinearLayoutManager(this)
        rv_1.adapter = cityAdapter
        rv_1.setHasFixedSize(true)
    }
}