package com.example.proj

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class WelcomeActivity : AppCompatActivity() {

    val sharedPrefFile = "kotlinsharedpreference"

    override fun onCreate(savedInstanceState: Bundle?) {

        val sharedPref = getSharedPreferences("sharedPrefFile", MODE_PRIVATE)
        val c = sharedPref.getInt("New",0)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val button3 = findViewById<Button>(R.id.btnSave)
        button3.setOnClickListener {
            val intent = Intent(this, CheckActivity::class.java)
            val intent2 = Intent(this, HomeActivity::class.java)
            if(c == 1){
                startActivity(intent)
            }
            else{
                startActivity(intent2)
            }
        }
    }
}