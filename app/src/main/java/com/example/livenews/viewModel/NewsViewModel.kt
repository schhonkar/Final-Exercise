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

    val repo:NewsRepository = NewsRepository()
    private val context = getApplication<Application>().applicationContext
    val dataViewmodel:LiveData<ResponseDataModel> = repo.data


    fun getNewsData(keyword:String?,category:String){
        repo.getNews(keyword,category)
    }

    fun insertNews(data:NewsData){
            repo.insertData(context,data)

    }
    fun deleteNews(data:NewsData){

            repo.deleteNewsArtcle(context,data)

    }
    fun getNewsFromDatabase(): LiveData<List<NewsData>> {
        return repo.getNewsDataFromDatabase(context)
    }
}