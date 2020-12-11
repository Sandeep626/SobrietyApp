package com.example.proj

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class AffectActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_affect)

        val button3 = findViewById<Button>(R.id.btn3)
        button3.setOnClickListener {
            val intent3 = Intent(this, CalendarActivity::class.java)
            startActivity(intent3)
        }
    }
}