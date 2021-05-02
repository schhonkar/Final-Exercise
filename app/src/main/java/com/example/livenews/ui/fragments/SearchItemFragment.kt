package com.example.livenews.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.livenews.R
import com.example.livenews.adapter.AdapterHome
import com.example.livenews.adapter.AdapterSearch
import com.example.livenews.api.ApiClint
import com.example.livenews.model.NewsData
import com.example.livenews.model.ResponseDataModel
import com.example.livenews.viewModel.NewsViewModel
import kotlinx.android.synthetic.main.fragment_home_page.*
import kotlinx.android.synthetic.main.fragment_search_item.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchItemFragment : Fragment() {

    lateinit var adapter: AdapterSearch
    lateinit var viewmodel:NewsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search_item, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        progressBar1.visibility = View.INVISIBLE
        searchButton.setOnClickListener {
            if (searchEditText.text.isNotEmpty()) {
                val keyword = searchEditText.text.toString()
                progressBar1.visibility = View.VISIBLE
                setUi(keyword)
            }
            else
                searchEditText.error = "Please enter the keyword"

        }
    }


        fun setUi(keyword:String){
            viewmodel = ViewModelProvider(this).get(NewsViewModel(activity!!.application)::class.java)
            viewmodel.getNewsData(keyword,"general")
            viewmodel.dataViewmodel.observe(viewLifecycleOwner, Observer { a ->
                rvNewsList1.also {
                    it.layoutManager = LinearLayoutManager(requireContext())
                    it.setHasFixedSize(true)
                    it.adapter = AdapterSearch(activity as AppCompatActivity,a.data)
                }
            })
        }
}