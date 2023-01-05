package com.example.shoppinglistapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Entity
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities =[Category::class],
    version=1)
abstract class CategoryDatabase : RoomDatabase(){

    //abstaract method to get the data access object
    abstract fun getCategoryDao():CategoryDao

    //building room database with a companion object
    companion object{

        @Volatile private  var instance:CategoryDatabase ?=null
        private val LOCK = Any()
        operator fun invoke(context: Context) = instance?: synchronized(LOCK)
        {
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            CategoryDatabase::class.java,
            "categorydatabse"
        ).build()

    }


}