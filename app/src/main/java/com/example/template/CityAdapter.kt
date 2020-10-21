package com.example.template

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

 class CityAdapter(
     val city: ArrayList<City>,
     val context: Context
) : RecyclerView.Adapter<CityHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityHolder {
        val itemHolder = LayoutInflater.from(parent.context).inflate(R.layout.item_city, parent, false)
        return CityHolder(itemHolder)
    }

    override fun onBindViewHolder(holder: CityHolder, position: Int) {
        holder.bindItems(city[position])
        holder.itemView.setOnClickListener {
            /*if (position == 0) {
                Toast.makeText(context, "Russian",Toast.LENGTH_LONG).show()
            }*/
            var city= city.get(position)

            val text1: String = city.text
            val iImageView: Int = city.imageResource
            val aDescription: String = city.desc

            val intent = Intent(context, SecondActivity::class.java)

            intent.putExtra("title", text1)
            intent.putExtra("imageview1", iImageView)
            intent.putExtra("bDescreption", aDescription)

            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return city.size
    }
}