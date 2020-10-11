package com.example.template


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView



class MainActivity : AppCompatActivity() {

    lateinit var homeFragment: HomeFragment
    lateinit var favoriteFragment: FavoriteFragment
    lateinit var profileFragment: ProfileFragment
    lateinit var searchFragment: SearchFragment
    lateinit var addPhotoFragment: AddPhotoFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.btn_bottomNavigation)
        bottomNavigationView.setOnNavigationItemReselectedListener { item ->

            homeFragment = HomeFragment()
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.frame_layout, homeFragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit()

            when (item.itemId) {
                R.id.navigation_home -> {
                    homeFragment = HomeFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout, homeFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }
                R.id.navigation_profile -> {
                    profileFragment = ProfileFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout, profileFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }
                R.id.navigation_search -> {
                    searchFragment = SearchFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout, searchFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }
                R.id.navigation_favorite -> {
                    favoriteFragment = FavoriteFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout, favoriteFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }
                R.id.navigation_addPhoto -> {
                    addPhotoFragment = AddPhotoFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout, addPhotoFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }
            }
        }
    }
}