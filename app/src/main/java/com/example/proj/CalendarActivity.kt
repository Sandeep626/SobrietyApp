package com.example.proj

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CalendarView
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import kotlinx.android.synthetic.main.activity_home.*
import java.text.DateFormat
import java.time.LocalDate
import java.time.temporal.ChronoUnit
import java.util.*

class CalendarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)

        var calview = findViewById<CalendarView>(R.id.CalView)
        var dat = findViewById<TextView>(R.id.textView12)
        var streak = findViewById<TextView>(R.id.textView13)

        calview.setOnDateChangeListener { calendarView, year, month, day ->
            var date = day.toString() + "−" + (month + 1) + "−" + year
            val start = LocalDate.of(year,month +1,day)
            dat.text = start.toString()
            val now = LocalDate.now()
            val days = ChronoUnit.DAYS.between(start,now)
            streak.text = days.toString()
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