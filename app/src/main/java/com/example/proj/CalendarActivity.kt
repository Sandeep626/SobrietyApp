package com.example.proj

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class CalendarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)

        val button4 = findViewById<Button>(R.id.btn4)
        button4.setOnClickListener {
            val intent4 = Intent(this, HomeActivity::class.java)
            startActivity(intent4)
        }

        val button5 = findViewById<Button>(R.id.btn5)
        button5.setOnClickListener {
            val intent5 = Intent(this, HomeActivity::class.java)
            startActivity(intent5)
        }
    }
}