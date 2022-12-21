package com.example.shoppinglistapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val gotosignup = findViewById<TextView>(R.id.gotosignup)
        gotosignup.setOnClickListener{
            val intent = Intent(this,SingupActivity::class.java)
            startActivity(intent)
        }

    }
}