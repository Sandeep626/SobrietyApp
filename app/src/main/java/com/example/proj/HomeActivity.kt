package com.example.proj

import android.content.Intent
import android.icu.util.Calendar
import android.os.Bundle
import android.view.MenuItem
import android.widget.*
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class HomeActivity : AppCompatActivity() {
    val sharedPrefFile = "kotlinsharedpreference"
    val quoteFile = "Quotes"

    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val sharedPref = getSharedPreferences("sharedPrefFile", MODE_PRIVATE)
        val editor = sharedPref.edit()

        editor.putInt("New",1)
        editor.apply()
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
//        val intent4 = Intent(this, SettingsActivity::class.java).apply {
//        }
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
//                R.id.miItem4 -> startActivity(intent4)
                R.id.miItem5 -> startActivity(intent5)
                R.id.miItem6 -> startActivity(intent6)
            }
            true
        }

        val listView2 = findViewById<ListView>(R.id.list_view2)
        var ss = sharedPref.getString("Addiction$aw","")+ " - "+sharedPref.getString("streak$aw","0")+ " Days"
        var list2 = arrayListOf("ADDICTIONS")


        while (aw < v){
            aw=aw.inc()
            ss = sharedPref.getString("Addiction$aw","")+ " - "+sharedPref.getString("streak$aw","0")+ " Days"
            list2.add(ss)
        }
        val arrayAdapter: ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_list_item_1, list2)

        val button2 = findViewById<Button>(R.id.btnReset)
        button2.setOnClickListener {
            editor.clear()
            editor.putInt("Count",0)
            v = 0
            aw = 0
            editor.commit()
            arrayAdapter.clear()
            list2.clear()
        }



        listView2.adapter = arrayAdapter
        listView2.setOnItemClickListener { adapterView, view, i, l ->
            Toast.makeText(this, "Item selected " + list2[i], Toast.LENGTH_LONG).show()
        }


        var qt = findViewById<TextView>(R.id.Quotes)
        val quotePref = getSharedPreferences("affectfile", MODE_PRIVATE)
        val quoteeditor = quotePref.edit()
        var q = quotePref.getInt("que", 0)

        //storing mass quotes
        quoteeditor.putString("1", "Believe you can and you’re halfway there. – Theodore Roosevelt")
        quoteeditor.putString("2", "Sometimes you’ve just got to give yourself what you wish someone else would give you. – Dr. Phil")
        quoteeditor.putString("3", "Experience is not what happens to you, it is what you do with what happens to you. – Aldous Huxley")
        quoteeditor.putString("4", "Life is like riding a bicycle. To keep your balance you must keep moving. – Albert Einstein")
        quoteeditor.putString("5", "Hardships often prepare ordinary people for an extraordinary destiny. – C.S. Lewis")
        quoteeditor.putString("6", "Obstacles are those frightening things that become visible when we take our eyes off our goals. – Henry Ford")
        quoteeditor.putString("7", "The ultimate measure of a man is not where he stands in moments of comfort and convenience but where he stands at times of challenge and controversy. – Dr. Martin Luther King Jr.")

        quoteeditor.commit()

        val calendar: Calendar = Calendar.getInstance()
        val day: Int = calendar.get(Calendar.DAY_OF_WEEK)

        if (quotePref.contains(day.toString())) {
            qt.text = quotePref.getString(day.toString(), "")
        }


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}