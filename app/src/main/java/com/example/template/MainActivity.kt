package com.example.template


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_main.*
import java.text.FieldPosition


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setViewPagerAdapter()
        setBottomNavigation()
        setViewPagerListener()
    }

    private fun setBottomNavigation() {
        btn_bottomNavigation.setOnNavigationItemReselectedListener {
            vp_1.currentItem = when(it.itemId) {
                R.id.navigation_home -> 0
                R.id.navigation_search -> 1
                R.id.navigation_profile -> 2
                else -> 0
            }
            return@setOnNavigationItemReselectedListener
        }
    }

    private fun setViewPagerAdapter() {
        vp_1.adapter = MainPageAdapter(supportFragmentManager)
    }
    private fun setViewPagerListener() {
        vp_1.addOnPageChangeListener(object: ViewPager.OnPageChangeListener{
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                btn_bottomNavigation.selectedItemId = when(position) {
                    0 -> R.id.navigation_home
                    1 -> R.id.navigation_search
                    2 -> R.id.navigation_profile
                    else -> R.id.navigation_home
                }
            }

            override fun onPageScrollStateChanged(state: Int) {
            }
        })
    }
}