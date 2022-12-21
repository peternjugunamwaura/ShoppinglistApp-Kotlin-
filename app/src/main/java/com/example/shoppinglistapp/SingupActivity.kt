package com.example.shoppinglistapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase

class SingupActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_singup)
        val sigupbtn = findViewById<Button>(R.id.signupbutton);
        val username = findViewById<EditText>(R.id.username_edit_text)
        val password = findViewById<EditText>(R.id.edit_text)


// ...
// Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()
        sigupbtn.setOnClickListener{
            auth.createUserWithEmailAndPassword(username.text.toString(),password.text.toString())
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        val intent = Intent(this,HomepageActivity::class.java)
                        Toast.makeText(baseContext, "Registration Succesfull.", Toast.LENGTH_SHORT).show()
                        startActivity(intent)
                        finish()
                    } else {
                        // If sign in fails, display a message to the user.
                        Toast.makeText(baseContext, "Authentication failed.", Toast.LENGTH_SHORT).show()
                    }
                }

        }
    }
    fun ValidateInput()
    {

    }
}