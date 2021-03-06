package com.example.livenews.repository

import android.content.Context
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.RoomDatabase
import com.example.livenews.adapter.AdapterHome
import com.example.livenews.api.ApiClint
import com.example.livenews.db.NewsDatabase
import com.example.livenews.db.NewsDatabaseBuilder
import com.example.livenews.model.NewsData
import com.example.livenews.model.ResponseDataModel
import kotlinx.android.synthetic.main.fragment_home_page.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.Executors

class NewsRepository() {


    val accessKey = "1c5bd81035fb7fbbd80e0f084b929235"
    val data: MutableLiveData<ResponseDataModel> = MutableLiveData()

    /**
     * Function to get data from API
     * keyword is use to search a apecific news
     * category to search news by category
     */
    fun getNews(keyword:String?,category:String) {
        val news = ApiClint.getClint.getNewsData(accessKey, category, "in", "en", 100, keyword)

        news.enqueue(object : Callback<ResponseDataModel> {
            override fun onResponse(
                    call: Call<ResponseDataModel>,
                    response: Response<ResponseDataModel>
            ) {
                data.postValue(response.body())
            }

            override fun onFailure(call: Call<ResponseDataModel>, t: Throwable) {
                Log.e("Homepage", "Some Error Occured")
            }
        })
    }

    /**
     * Function to insert data in database
     * requires context and data of NewsData type
     */
    fun insertData(context: Context, data:NewsData) {
    val database = NewsDatabaseBuilder().getInstance(context)
    Executors.newSingleThreadExecutor().execute {
        database.newsDao().insert(data)
        }
    }
    /**
     * Function to get data from database
     * requires context
     */
    fun getNewsDataFromDatabase(context: Context): LiveData<List<NewsData>> {
        val database = NewsDatabaseBuilder().getInstance(context)
           return database.newsDao().getAllData()
    }
    /**
     * Function to delete data from database
     * requires context and data of NewsData type
     */
     fun deleteNewsArtcle(context: Context, data:NewsData){
        val database =  NewsDatabaseBuilder().getInstance(context)
        Executors.newSingleThreadExecutor().execute {
            database.newsDao().deleteNews(data)
        }
    }

}
