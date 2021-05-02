package com.example.livenews.api

import com.example.livenews.model.ResponseDataModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitInterface {

    @GET("news")
    fun getNewsData(
        @Query("access_key")
        accessKey:String,
        @Query("categories")
        category: String,
        @Query("countries")
        countries:String,
        @Query("language")
        languages:String,
        @Query("limit")
        limit:Int,
        @Query("keywords")
        keywords: String?
    ):Call<ResponseDataModel>
}