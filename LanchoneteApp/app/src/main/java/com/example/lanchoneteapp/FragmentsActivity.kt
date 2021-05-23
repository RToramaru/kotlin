package com.example.lanchoneteapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.View.inflate
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.res.ColorStateListInflaterCompat.inflate
import androidx.core.graphics.drawable.DrawableCompat.inflate
import androidx.fragment.app.Fragment
import com.example.lanchoneteapp.fragments.CartFragment
import com.example.lanchoneteapp.fragments.HistoryFragment
import com.example.lanchoneteapp.fragments.HomeFragment
import com.example.lanchoneteapp.fragments.SettingsFragment
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.activity_fragments.*
import kotlinx.android.synthetic.main.fragment_settings.*

class FragmentsActivity : AppCompatActivity() {

    private val homeFragment = HomeFragment()
    private val cartFragment = CartFragment()
    private val historyFragment = HistoryFragment()
    private val settingsFragment = SettingsFragment()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragments)
        replaceFragment(homeFragment)
        bottom_navigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.menu_home -> replaceFragment(homeFragment)
                R.id.menu_cart -> replaceFragment(cartFragment)
                R.id.menu_history-> replaceFragment(historyFragment)
                R.id.menu_settings -> replaceFragment(settingsFragment)
            }
            true
        }

    }

    private fun replaceFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.commit()
    }
}