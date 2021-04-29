package com.example.livenews.model

import com.example.livenews.model.NewsData
import com.google.gson.annotations.SerializedName

data class ResponseDataModel(

    @SerializedName("data")
    val data: ArrayList<NewsData>
)

