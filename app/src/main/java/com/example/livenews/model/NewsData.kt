package com.example.livenews.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity(tableName = "NewsData")
data class NewsData(
    @PrimaryKey(autoGenerate = true)
    var id:Int? = null,
    @SerializedName("author")
    val author:String,
    @SerializedName("title")
    val title:String,
    @SerializedName("url")
    val url:String,
    @SerializedName("image")
    val image:String,
    @SerializedName("description")
    val description:String,
    @SerializedName("published_at")
    val pulished_at:String
)
