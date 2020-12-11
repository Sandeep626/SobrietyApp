package com.example.proj

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class CheckActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check)

        val button3 = findViewById<Button>(R.id.btnYes)
        button3.setOnClickListener {
            val intent = Intent(this, HowActivity::class.java)
            startActivity(intent)
        }

        val button0 = findViewById<Button>(R.id.btnNo)
        button0.setOnClickListener {
            val intent = Intent(this, WhyActivity::class.java)
            startActivity(intent)
        }
    }
}