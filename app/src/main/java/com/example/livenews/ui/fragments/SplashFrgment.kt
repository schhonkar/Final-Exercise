package com.example.livenews.ui.fragments

import android.content.Context
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.livenews.R
import com.example.livenews.ui.MainActivity


class SplashFrgment : Fragment() {


    val TIME_OUT:Long = 2000
    private lateinit var navController: NavController


//    override fun onAttach(context: Context) {
//        super.onAttach(context)
//        (activity as MainActivity).hideBottomNavigation()
//    }
//
//    override fun onDetach() {
//        super.onDetach()
//        (activity as MainActivity).showBottomNavigation()
//    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash_frgment, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.hide()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        navController = findNavController()
        loadSplashScreen()
    }

    private fun loadSplashScreen(){
        Handler().postDelayed({
            // You can declare your desire activity here to open after finishing splash screen. Like MainActivity
            goToHomeScreen()
        }, TIME_OUT)
    }

    private fun goToHomeScreen(){
        val action = SplashFrgmentDirections.actionSplashFrgmentToHomePageFragment()
        navController.navigate(action)
    }

}