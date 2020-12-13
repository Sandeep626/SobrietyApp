package com.example.proj

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AddictionActivity : AppCompatActivity() {
    //create shared pref file
    val sharedPrefFile = "kotlinsharedpreference"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addiction)

        //create object and editor
        var sharedPref = getSharedPreferences("sharedPrefFile", MODE_PRIVATE)
        var editor = sharedPref.edit()
        var v = sharedPref.getInt("Count",0)

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

            editor.putString("Addiction$v", list[i])
            editor.commit()
            Toast.makeText(this, "Item selected " + sharedPref.getString("Addiction$v", "default"), Toast.LENGTH_LONG).show()
        }

        val button2 = findViewById<Button>(R.id.btnNext)
        button2.setOnClickListener {
            val intent2 = Intent(this, AffectActivity::class.java)

            startActivity(intent2)
        }
    }
}
