package com.example.proj

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CalendarView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CalendarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)


        val button5 = findViewById<Button>(R.id.btn5)
        button5.setOnClickListener {
            val intent5 = Intent(this, HomeActivity::class.java)
            startActivity(intent5)
        }

        val cal = findViewById<CalendarView>(R.id.CalView)
        val dat = findViewById<TextView>(R.id.textView12)

    }
}