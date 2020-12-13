package com.example.proj

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val button3 = findViewById<Button>(R.id.btnSave)
        button3.setOnClickListener {
            val intent = Intent(this, CheckActivity::class.java)
            startActivity(intent)
        }
    }
}