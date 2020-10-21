package com.example.template

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_city.view.*
import kotlinx.android.synthetic.main.item_city.view.iv_city1

class CityHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bindItems(city: City) {
        itemView.iv_city1.setImageResource(city.imageResource)
        itemView.tv_city2.text = city.text
        itemView.tv_descreption.text = city.desc
    }

}