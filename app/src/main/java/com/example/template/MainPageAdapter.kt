package com.example.template

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class MainPageAdapter (var fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
    override fun getCount(): Int {
        return 3
    }

    override fun getItem(position: Int): Fragment {
        return when(position) {
            0 -> HomeFragment.newInstance()
            1 -> SearchFragment.newInstance()
            2 -> ProfileFragment.newInstance()
            else -> HomeFragment.newInstance()
        }
    }

}