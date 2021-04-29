package com.example.livenews.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.livenews.model.NewsData


@Dao
interface NewsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(newsData: NewsData):Long

    @Query("SELECT * FROM NewsData")
    suspend fun getAllData():LiveData<List<NewsData>>

    @Delete
    suspend fun deleteNews(newsData: NewsData)
}