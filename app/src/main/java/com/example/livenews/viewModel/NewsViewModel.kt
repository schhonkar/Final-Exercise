package com.example.livenews.viewModel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.livenews.model.NewsData
import com.example.livenews.model.ResponseDataModel
import com.example.livenews.repository.NewsRepository
import kotlinx.coroutines.launch

class NewsViewModel(application: Application): AndroidViewModel(application) {
    //making instance of Repository
    val repo:NewsRepository = NewsRepository()
    //getting context in viewmodel
    private val context = getApplication<Application>().applicationContext
    val dataViewmodel:LiveData<ResponseDataModel> = repo.data

    /**
     * TO call the data from Api from Repo
     */
    fun getNewsData(keyword:String?,category:String){
        repo.getNews(keyword,category)
    }

    /**
     * TO insert the data in database using Repo
     */
    fun insertNews(data:NewsData){
            repo.insertData(context,data)
    }

    /**
     * To delete the data from Database
     */
    fun deleteNews(data:NewsData){
            repo.deleteNewsArtcle(context,data)
    }

    /**
     * to get the data from database
     */
    fun getNewsFromDatabase(): LiveData<List<NewsData>> {
        return repo.getNewsDataFromDatabase(context)
    }
}