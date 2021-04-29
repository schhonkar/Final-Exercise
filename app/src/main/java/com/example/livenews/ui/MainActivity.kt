package com.example.livenews.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.livenews.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onResume() {
        super.onResume()
        bottomNavigationView.setupWithNavController(nav_host_fragment.findNavController())
    }

//    fun hideBottomNavigation()
//    {
//        bottomNavigationView.visibility = View.GONE
//    }
//    fun showBottomNavigation()
//    {
//        bottomNavigationView.visibility = View.VISIBLE
//    }

}