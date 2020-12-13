package com.example.proj

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CalendarView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.time.LocalDate
import java.time.temporal.ChronoUnit

class CalendarActivity : AppCompatActivity() {

    val sharedPrefFile = "kotlinsharedpreference"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)

        val sharedPref = getSharedPreferences("sharedPrefFile", MODE_PRIVATE)
        val editor = sharedPref.edit()
        var v = sharedPref.getInt("Count",0)

        var calview = findViewById<CalendarView>(R.id.CalView)
        var dat = findViewById<TextView>(R.id.textView12)
        var streak = findViewById<TextView>(R.id.textView13)

        calview.setOnDateChangeListener { calendarView, year, month, day ->
            var date1 = day.toString() + "−" + (month + 1) + "−" + year
            val start = LocalDate.of(year,month +1,day)
            dat.text = start.toString()
            val now = LocalDate.now()
            val days = ChronoUnit.DAYS.between(start,now)
            streak.text = days.toString()
            var st = days.toString()

            editor.putString("streak$v", st)
            editor.putString("date$v", start.toString())
            editor.apply()
        }

        val button5 = findViewById<Button>(R.id.btn5)
        button5.setOnClickListener {
            val intent5 = Intent(this, HomeActivity::class.java)
            intent5.putExtra("Date", dat.text) //date
            intent5.putExtra("Streak", streak.text) //days
            startActivity(intent5)
        }
    }
}