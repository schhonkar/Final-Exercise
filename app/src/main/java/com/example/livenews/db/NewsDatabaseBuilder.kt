package com.example.livenews.db

import android.content.Context
import androidx.room.Room

class NewsDatabaseBuilder {

    private var INSTANCE: NewsDatabase? = null

    fun getInstance(context: Context): NewsDatabase {
        if (INSTANCE == null) {
            synchronized(NewsDatabase::class) {
                INSTANCE = buildRoomDB(context)
            }
        }
        return INSTANCE!!
    }

    private fun buildRoomDB(context: Context) =
            Room.databaseBuilder(
                    context.applicationContext,
                    NewsDatabase::class.java,
                    "roomdbexample"
            ).fallbackToDestructiveMigration().build()
}

