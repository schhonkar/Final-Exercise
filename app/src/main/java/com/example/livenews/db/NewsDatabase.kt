package com.example.livenews.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.livenews.model.NewsData


@Database(
        entities = [NewsData::class],
        version = 2
)
abstract class NewsDatabase:RoomDatabase() {

    abstract fun newsDao():NewsDao
}