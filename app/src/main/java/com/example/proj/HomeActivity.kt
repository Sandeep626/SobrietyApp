package com.example.proj

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class HomeActivity : AppCompatActivity() {
    val sharedPrefFile = "kotlinsharedpreference"

    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val sharedPref = getSharedPreferences("sharedPrefFile", MODE_PRIVATE)
        val editor = sharedPref.edit()
        //editor.putInt("Count",0)
        var v = sharedPref.getInt("Count",0)
        var aw = 0
        if(v > 6){
            editor.putInt("Count",0)
        }


        val intent = Intent(this, AddictionActivity::class.java).apply {
        }
        val intent2 = Intent(this, MainActivity::class.java).apply {
        }
        val intent3 = Intent(this, MotvActivity::class.java).apply {
        }
        val intent4 = Intent(this, SettingsActivity::class.java).apply {
        }
        val intent5 = Intent(this, SaveActivity::class.java).apply {
        }
        val intent6 = Intent(this, HelpActivity::class.java).apply {
        }

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val button = findViewById<Button>(R.id.btnadd2)
        button.setOnClickListener {
            v =v.inc()
            editor.putInt("Count",v)
            editor.commit()
            startActivity(intent)
        }

        navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.miItem1 -> Toast.makeText(applicationContext, "Already Here", Toast.LENGTH_SHORT).show()
                R.id.miItem2 -> startActivity(intent2)
                R.id.miItem3 -> startActivity(intent3)
                R.id.miItem4 -> startActivity(intent4)
                R.id.miItem5 -> startActivity(intent5)
                R.id.miItem6 -> startActivity(intent6)
            }
            true
        }

        val listView2 = findViewById<ListView>(R.id.list_view2)
        var list2 = arrayListOf(sharedPref.getString("Addiction0",""))

        while (aw <= v){
            aw=aw.inc()
            list2.add(sharedPref.getString("Addiction$aw",""))
        }
        val arrayAdapter: ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_list_item_1, list2)

        val button2 = findViewById<Button>(R.id.btnReset)
        button2.setOnClickListener {
            editor.clear()
            editor.putInt("Count",0)
            editor.commit()
            arrayAdapter.clear()
        }



        listView2.adapter = arrayAdapter
        listView2.setOnItemClickListener { adapterView, view, i, l ->
            Toast.makeText(this, "Item selected " + list2[i], Toast.LENGTH_LONG).show()
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}

fun inc(){

}