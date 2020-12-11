package com.example.proj

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class WhyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_why)

        val button3 = findViewById<Button>(R.id.btnSave)
        button3.setOnClickListener {
            val intent3 = Intent(this, HomeActivity::class.java)
            startActivity(intent3)
        }

        val button0 = findViewById<Button>(R.id.btnCont)
        button0.setOnClickListener {
            val intent3 = Intent(this, HomeActivity::class.java)
            startActivity(intent3)
        }
    }
}