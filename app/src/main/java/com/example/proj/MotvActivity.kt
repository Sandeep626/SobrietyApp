package com.example.proj

import android.app.DatePickerDialog
import android.content.Intent
import android.icu.util.Calendar
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_motv.*
import java.time.LocalDateTime

class MotvActivity : AppCompatActivity() {

    val journalPrefFile = "kotlinsharedpreference"

    val currentDateTime = LocalDateTime.now()
    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_motv)

        val journalPref = getSharedPreferences("journalPrefFile", MODE_PRIVATE)
        val jrnlEditor = journalPref.edit()
        var cal = Calendar.getInstance()
        val year = cal.get(Calendar.YEAR)
        val month = cal.get(Calendar.MONTH)
        val day = cal.get(Calendar.DAY_OF_MONTH)

        val intent1 = Intent(this,HomeActivity::class.java).apply {
        }
        val intent2 = Intent(this, MainActivity::class.java).apply {
        }
//        val intent4 = Intent(this, SettingsActivity::class.java).apply {
//        }
        val intent5 = Intent(this, SaveActivity::class.java).apply {
        }
        val intent6 = Intent(this,HelpActivity::class.java).apply {
        }
        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.miItem1 -> startActivity(intent1)
                R.id.miItem2 -> startActivity(intent2)
                R.id.miItem3 -> Toast.makeText(
                    applicationContext,
                    "Already Here",
                    Toast.LENGTH_SHORT
                ).show()
//                R.id.miItem4 -> startActivity(intent4)
                R.id.miItem5 -> startActivity(intent5)
                R.id.miItem6 -> startActivity(intent6)
            }
            true
        }

        val dd = DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { DatePicker, year, month, dayOfMonth ->
                textViewD.text = journalPref.getString("$year/$month/$dayOfMonth","No Entry For This Date")
                dt1.setText("$year/$month/$dayOfMonth")
            },
            year,
            month,
            day
        )
        dd.show()

        val button = findViewById<Button>(R.id.btnNew)
        button.setOnClickListener {
            finish()
            startActivity(intent)
        }

    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}