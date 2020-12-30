package com.example.template.fragments.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.template.R
import com.example.template.data.User
import kotlinx.android.synthetic.main.fragment_list.view.*

class ListAdapter: RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var userList = emptyList<User>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.fragment_list, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentItem = userList[position]
    }

    override fun getItemCount(): Int {

        return userList.size
    }
}