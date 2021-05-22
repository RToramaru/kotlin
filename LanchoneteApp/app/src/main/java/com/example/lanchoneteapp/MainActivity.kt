package com.example.lanchoneteapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.lanchoneteapp.fragments.CartFragment
import com.example.lanchoneteapp.fragments.HistoryFragment
import com.example.lanchoneteapp.fragments.HomeFragment
import com.example.lanchoneteapp.fragments.SettingsFragment
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationMenu

class MainActivity : AppCompatActivity() {

    // usar na classe fragments
    private val homeFragment = HomeFragment()
    private val cartFragment = CartFragment()
    private val historyFragment = HistoryFragment()
    private val settingsFragment = SettingsFragment()
    // fim

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //usar na classe do fragemnet
        /*
        replaceFragment(homeFragment)
        bottom_navigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.ic_home -> replaceFragment(homeFragment)
                R.id.ic_cart-> replaceFragment(cartFragment)
                R.id.ic_history -> replaceFragment(historyFragment)
                R.id.ic_settings -> replaceFragment(settingsFragment)
            }
            true
        }*/
        // fim
    }

    // usar na classe fragmentes
    private fun replaceFragment(fragment: Fragment) {
        if (fragment != null) {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, fragment)
            transaction.commit()
        }
    }
    // fim
}