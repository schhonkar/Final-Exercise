package com.example.livenews.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.livenews.R
import com.example.livenews.ui.MainActivity
import kotlinx.android.synthetic.main.fragment_category.*


class CategoryFragment : Fragment() {


    lateinit var categary:String
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /**
         * Navigation to HomePage Fragment to get the data using category
         */
        ctSport.setOnClickListener {
            categary = "sports"
            val action = CategoryFragmentDirections.actionCategoryFragmentToHomePageFragment(
                categary!!
            )
            findNavController().navigate(action)
        }
        ctBuisness.setOnClickListener {
            categary = "business"
            val action = CategoryFragmentDirections.actionCategoryFragmentToHomePageFragment(
                categary!!
            )
            findNavController().navigate(action)
        }
        ctEntertainment.setOnClickListener {
            categary = "entertainment"
            val action = CategoryFragmentDirections.actionCategoryFragmentToHomePageFragment(
                categary!!
            )
            findNavController().navigate(action)
        }
        ctHealth.setOnClickListener {
            categary = "health"
            val action = CategoryFragmentDirections.actionCategoryFragmentToHomePageFragment(
                categary!!
            )
            findNavController().navigate(action)
        }
        ctScience.setOnClickListener {
            categary = "science"
            val action = CategoryFragmentDirections.actionCategoryFragmentToHomePageFragment(
                categary!!
            )
            findNavController().navigate(action)
        }
        ctTechnology.setOnClickListener {
            categary = "technology"
            val action = CategoryFragmentDirections.actionCategoryFragmentToHomePageFragment(
                categary!!
            )
            findNavController().navigate(action)
        }
    }
}