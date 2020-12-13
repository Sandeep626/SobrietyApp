package com.example.proj

import android.content.Intent
import android.icu.text.SimpleDateFormat
import android.icu.util.Calendar
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_why.*

class WhyActivity : AppCompatActivity() {

    val journalPrefFile = "kotlinsharedpreference"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_why)

        val journalPref = getSharedPreferences("journalPrefFile", MODE_PRIVATE)
        val jrnlEditor = journalPref.edit()
        val dateToday = SimpleDateFormat("yyyy/MM/dd").toString()
        var cal = Calendar.getInstance()
        val year = cal.get(Calendar.YEAR)
        val month = cal.get(Calendar.MONTH)
        val day = cal.get(Calendar.DAY_OF_MONTH)
        var dd = ("$year/$month/$day").toString()

        val button3 = findViewById<Button>(R.id.btnSave)
        button3.setOnClickListener {
            val intent3 = Intent(this, HomeActivity::class.java)
            jrnlEditor.putString("$dd", Journal2.text.toString())
            jrnlEditor.apply()
            startActivity(intent3)
        }

        val button0 = findViewById<Button>(R.id.btnCont)
        button0.setOnClickListener {
            val intent3 = Intent(this, HomeActivity::class.java)
            startActivity(intent3)
        }
    }
}