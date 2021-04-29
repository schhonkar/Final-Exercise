package com.example.livenews.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.livenews.*
import com.example.livenews.adapter.AdapterHome
import com.example.livenews.api.ApiClint
import com.example.livenews.model.NewsData
import com.example.livenews.model.ResponseDataModel
import kotlinx.android.synthetic.main.fragment_home_page.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomePageFragment : Fragment() {

    val accessKey = "1c5bd81035fb7fbbd80e0f084b929235"
    val newsData = ArrayList<NewsData>()
    lateinit var adapter: AdapterHome


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

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        progressBar.visibility = View.VISIBLE
        getNews()
    }

    private fun getNews() {
        val news = ApiClint.getClint.getNewsData(accessKey,"general","in","en",100,null)

        news.enqueue(object :Callback<ResponseDataModel>{
            override fun onResponse(
                call: Call<ResponseDataModel>,
                response: Response<ResponseDataModel>
            ) {
                newsData.addAll(response.body()?.data?:ArrayList())
                adapter = AdapterHome(activity!!,newsData)
                rvNewsList.adapter = adapter
                rvNewsList.layoutManager = LinearLayoutManager(activity)
                progressBar.visibility = View.GONE
            }

            override fun onFailure(call: Call<ResponseDataModel>, t: Throwable) {
                Log.e("Homepage","Some Error Occured")
            }

        })



    }


}