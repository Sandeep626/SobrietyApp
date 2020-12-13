package com.example.proj

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class SaveActivity : AppCompatActivity() {
    val affectfile = "Affects"

    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_save)

        val intent1 = Intent(this,HomeActivity::class.java).apply {
        }
        val intent2 = Intent(this, MainActivity::class.java).apply {
        }
        val intent3 = Intent(this, MotvActivity::class.java).apply {
        }
//        val intent4 = Intent(this, SettingsActivity::class.java).apply {
//        }
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
                R.id.miItem3 -> startActivity(intent3)
                R.id.miItem5 -> Toast.makeText(
                    applicationContext,
                    "Already Here",
                    Toast.LENGTH_SHORT
                ).show()
//                R.id.miItem4 -> startActivity(intent4)
                R.id.miItem6 -> startActivity(intent6)
            }
            true
        }
        val affectPref = getSharedPreferences("affectfile", MODE_PRIVATE)
        val affecteditor = affectPref.edit()
        var a = affectPref.getInt("problems", 0)
        a--

        var wloss = affectPref.getFloat("affectmoney$a", 0F)
        var wtime = affectPref.getFloat("affecttime$a", 0F)

        var s1 = findViewById<TextView>(R.id.save1)
        var s2 = findViewById<TextView>(R.id.save2)
        var s3 = findViewById<TextView>(R.id.save3)
        var s4 = findViewById<TextView>(R.id.save4)

        s2.text = (wloss * 52).toString()
        s4.text = (wtime * 52).toString()

        s1.text = (wloss / 7).toString()
        s3.text = (wtime / 7).toString()
        a++
        affecteditor.commit()

        val exit3 = findViewById<Button>(R.id.btnExit3)
        exit3.setOnClickListener {
            val intent12 = Intent(this, HomeActivity::class.java)
            startActivity(intent12)
        }
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}