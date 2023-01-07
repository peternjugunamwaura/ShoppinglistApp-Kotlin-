package com.example.shoppinglistapp.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CategoryDao {

    @Insert
    suspend fun insertCategory(category: Category)

    @Query(value = "select * FROM Category")
    suspend fun getCategories():List<Category>
}