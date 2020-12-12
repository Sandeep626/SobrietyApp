package com.example.proj

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AddictionActivity : AppCompatActivity() {
    private val sharedPrefFile = "kotlinsharedpreference"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addiction)
        
        val sharedPreferences: SharedPreferences = this.getSharedPreferences(sharedPrefFile,
            Context.MODE_PRIVATE)

        val listView = findViewById<ListView>(R.id.list_view)
        val list = arrayListOf(
            "Alcohol",
            "Smoking",
            "Narcotics",
            "Procrastination",
            "Social Media",
            "Eating",
            "Porn"
        )
        val arrayAdapter: ArrayAdapter<String> =
            ArrayAdapter(this, android.R.layout.simple_list_item_1, list)

        listView.adapter = arrayAdapter
        listView.setOnItemClickListener { adapterView, view, i, l ->

            val editor:SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString("Addiction",list[i])
            editor.apply()
            editor.commit()
            Toast.makeText(this, "Item selected " + sharedPreferences.getString("Addiction","default"), Toast.LENGTH_LONG).show()
        }

        val button1 = findViewById<Button>(R.id.btn1)
        button1.setOnClickListener {
            val intent1 = Intent(this, HomeActivity::class.java)
            startActivity(intent1)
        }
        val button2 = findViewById<Button>(R.id.btn2)
        button2.setOnClickListener {
            val intent2 = Intent(this, AffectActivity::class.java)
            startActivity(intent2)
        }
    }
}
