package com.example.shoppinglistapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //directing to signup
        val gotosignup = findViewById<TextView>(R.id.gotosignup)
        gotosignup.setOnClickListener{
            val intent = Intent(this,SingupActivity::class.java)
            startActivity(intent)
        }
        //Loging in the user
        val usernameEditText = findViewById<EditText>(R.id.username_edit_text)
        val password = findViewById<EditText>(R.id.edit_textpassword)
        val loginbtn = findViewById<Button>(R.id.loginbutton)
        auth = FirebaseAuth.getInstance()
        loginbtn.setOnClickListener {
            auth.signInWithEmailAndPassword(
                usernameEditText.text.toString(),
                password.text.toString()
            ).addOnCompleteListener (this){
                task->if(task.isSuccessful)
            {
                    startActivity(Intent(this,HomepageActivity::class.java))
                }
                else
            {
                val snackbar = Snackbar.make(it,"Incorrect Login Details",Snackbar.LENGTH_SHORT)
                snackbar.show()
            }

            }
        }


    }
}