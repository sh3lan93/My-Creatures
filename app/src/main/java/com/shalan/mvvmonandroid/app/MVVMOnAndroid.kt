package com.shalan.mvvmonandroid.app

import android.app.Application
import androidx.room.Room
import com.shalan.mvvmonandroid.model.room.CreaturesDatabase

/**
 * Created by Mohamed Shalan on 2019-12-06.
 */
class MVVMOnAndroid : Application() {

    companion object {
        lateinit var database: CreaturesDatabase
    }

    override fun onCreate() {
        super.onCreate()
        database =
            Room.databaseBuilder(this, CreaturesDatabase::class.java, "creature_database").build()
    }
}