package com.example.proj

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class AffectActivity : AppCompatActivity() {
    val affectfile = "Affects"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_affect)

        var mless = 0F
        var tless = 0F

        val affectPref = getSharedPreferences("affectfile", MODE_PRIVATE)
        val affecteditor = affectPref.edit()
        var a = affectPref.getInt("problems", 0)

        val n1 = findViewById<EditText>(R.id.number1)
        val n2 = findViewById<EditText>(R.id.number2)

        val button3 = findViewById<Button>(R.id.btn3)
        button3.setOnClickListener {
            mless = n1.text.toString().toFloat()
            tless = n2.text.toString().toFloat()

            affecteditor.putFloat( "affectmoney$a", mless)
            affecteditor.putFloat( "affecttime$a", tless)

            a++
            affecteditor.putInt("problems", a)
            affecteditor.apply()

            val intent3 = Intent(this, CalendarActivity::class.java)
            startActivity(intent3)
        }
    }
}