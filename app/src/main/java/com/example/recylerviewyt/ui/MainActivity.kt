package com.example.recylerviewyt.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.recylerviewyt.R
import com.example.recylerviewyt.ui.fragment.HomeFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       replaceFragment(HomeFragment())
    }

    private fun replaceFragment(homeFragment: HomeFragment) {
        val fragmentManager=supportFragmentManager
        val fragmentTransaction=fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,homeFragment)
        fragmentTransaction.commit()
    }
}