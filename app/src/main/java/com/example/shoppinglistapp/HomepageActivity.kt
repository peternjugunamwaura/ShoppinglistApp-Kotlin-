package com.example.shoppinglistapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class HomepageActivity : AppCompatActivity() {
    lateinit var showButton: Button
    lateinit var addCategory: AddCategory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)
        showButton = findViewById(R.id.addcategory)
        showButton.setOnClickListener {
            showBottomNavigation()

        }


    }
    fun showBottomNavigation()
    {
        addCategory = AddCategory()
        addCategory.show(supportFragmentManager,"Addtask")

    }
}