package com.example.proj

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AddictionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addiction)

        val listView = findViewById<ListView>(R.id.list_view)
        val list = arrayListOf("Alcohol", "Smoking", "Narcotics", "Procrastination", "Social Media", "Eating", "Porn");
        val arrayAdapter: ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_list_item_1, list)

        listView.adapter = arrayAdapter
        listView.setOnItemClickListener { adapterView, view, i, l ->
            Toast.makeText(this, "Item selected " + list[i], Toast.LENGTH_LONG).show()
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