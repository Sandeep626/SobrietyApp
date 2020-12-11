package com.example.proj

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_how.*

class HelpActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_help)

        val button3 = findViewById<Button>(R.id.btnEx)
        button3.setOnClickListener {
            val intent3 = Intent(this, HomeActivity::class.java)
            startActivity(intent3)
        }

        textView4.text="Canada\n" +
                "Wellness Together Canada\n" +
                "1-866-585-0445\n" +
                "Canada\n" +
                "Kids Help Phone\n" +
                "1-800-668-6868\n" +
                "\n" +
                "Ontario\n" +
                "Addiction, Mental Health, and Problem Gambling Services (ConnexOntario)\n" +
                "1-866-531-2600\n" +
                "Ontario\n" +
                "Distress and Crisis Ontario\n" +
                "Most centres are open 24 hours\n" +
                "Call a distress centre in your area\n" +
                "\n" +
                "Suidice hotline1.833.456.4566\n" +
                "Available 24/7/365"
    }
}