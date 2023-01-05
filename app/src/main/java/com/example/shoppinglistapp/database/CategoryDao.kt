package com.example.shoppinglistapp.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CategoryDao {

    @Insert
    fun insertCategory(category: Category)

    @Query(value = "select * FROM Category")
    fun getCategories():List<Category>
}