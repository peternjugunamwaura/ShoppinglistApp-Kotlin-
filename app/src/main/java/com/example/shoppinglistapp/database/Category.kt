package com.example.shoppinglistapp.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Category (


    val title : String,
    val description: String
    )
{
    //removing id from the
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

}
