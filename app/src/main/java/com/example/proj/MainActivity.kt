package com.example.proj

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent1 = Intent(this,HomeActivity::class.java).apply {
        }
        val intent3 = Intent(this,MotvActivity::class.java).apply {
        }
//        val intent4 = Intent(this,SettingsActivity::class.java).apply {
//        }
        val intent5 = Intent(this,SaveActivity::class.java).apply {
        }
        val intent6 = Intent(this,HelpActivity::class.java).apply {
        }
        val intent7 = Intent(this,HowActivity::class.java).apply {
        }
        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.miItem1 -> startActivity(intent1)
                R.id.miItem2 -> Toast.makeText(applicationContext,"Already Here",Toast.LENGTH_SHORT).show()
                R.id.miItem3 -> startActivity(intent3)
//                R.id.miItem4 -> startActivity(intent4)
                R.id.miItem5 -> startActivity(intent5)
                R.id.miItem6 -> startActivity(intent6)
            }
            true
        }
        val button = findViewById<Button>(R.id.btnJournal)
        button.setOnClickListener {
            startActivity(intent7)
        }

        val button2 = findViewById<Button>(R.id.btnExit)
        button2.setOnClickListener {
            startActivity(intent1)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}