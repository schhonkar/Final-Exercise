package com.example.livenews.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.livenews.R
import com.example.livenews.adapter.AdapterHome
import com.example.livenews.adapter.AdapterSaveDatabase
import com.example.livenews.model.NewsData
import com.example.livenews.ui.MainActivity
import com.example.livenews.viewModel.NewsViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_home_page.*
import kotlinx.android.synthetic.main.fragment_saved_item.*


/**
 * A simple [Fragment] subclass.
 * Use the [SavedItemFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SavedItemFragment : Fragment() {

    lateinit var adapter: AdapterSaveDatabase
    lateinit var viewmodel: NewsViewModel



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_saved_item, container, false)
    }



    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setUi()
    }

    fun setUi(){
        viewmodel = ViewModelProvider(this).get(NewsViewModel(activity!!.application)::class.java)
        viewmodel.getNewsFromDatabase().observe(viewLifecycleOwner, Observer {articles ->
            rvNewsListSave.also {
                it.layoutManager = LinearLayoutManager(requireContext())
                it.setHasFixedSize(true)
                it.adapter = AdapterSaveDatabase(activity as AppCompatActivity,articles as ArrayList<NewsData>)
            }
        })
    }
}