package com.example.livenews.ui.fragments

import android.app.Application
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.livenews.*
import com.example.livenews.adapter.AdapterHome
import com.example.livenews.api.ApiClint
import com.example.livenews.model.NewsData
import com.example.livenews.model.ResponseDataModel
import com.example.livenews.ui.MainActivity
import com.example.livenews.viewModel.NewsViewModel
import kotlinx.android.synthetic.main.fragment_home_page.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomePageFragment : Fragment() {

    lateinit var adapter: AdapterHome
    lateinit var viewmodel:NewsViewModel
    val args :HomePageFragmentArgs by navArgs()
    //Optional category to get news by Category
    lateinit var category:String
    //Making instance to get the connectivity method
    val mainActivity = MainActivity()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_page, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.hide()
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if(mainActivity.isOnline(activity as AppCompatActivity)){
            setUi()
        }
        else{
            internetCheckText.visibility = View.VISIBLE
            progressBar.visibility = View.INVISIBLE
        }

    }

    /**
     *To set up the UI of HomePage Fragment
     */
    fun setUi(){
        progressBar.visibility = View.VISIBLE
        viewmodel = ViewModelProvider(this).get(NewsViewModel(activity!!.application)::class.java)
        category = args.category
        viewmodel.getNewsData(null,category)
        viewmodel.dataViewmodel.observe(viewLifecycleOwner, Observer { a ->
            rvNewsList.also {
                it.layoutManager = LinearLayoutManager(requireContext())
                it.setHasFixedSize(true)
                it.adapter = AdapterHome(activity as AppCompatActivity,a.data)
            }
        })
    }

}