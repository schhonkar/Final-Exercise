package com.example.livenews.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.livenews.model.NewsData


@Dao
interface NewsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun insert(newsData: NewsData):Long

    @Query("SELECT * FROM NewsData")
    fun getAllData(): LiveData<List<NewsData>>

    @Delete
    fun deleteNews(newsData: NewsData)

}