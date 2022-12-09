package com.example.to_do

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Switch
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var backPressedTime:Long = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val switch_brwsr = findViewById<Switch>(R.id.switchBrowser).setOnCheckedChangeListener{ _, isChecked ->
            if (isChecked){
                val intent = Intent(this,WebBrowse::class.java)
                startActivity(intent)
            }
        }

        addTask.setOnClickListener {
            val intent = Intent(this, CreateCard::class.java)
            startActivity(intent)
        }

        val linearLayoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

        recyclerView.adapter = Adapter(DataObject.getAllData())
        recyclerView.layoutManager = linearLayoutManager
    }


//    override fun onRestart() {
//        super.onRestart()
//        startActivity(Intent(this,SplashScreen::class.java))
//    }

    override fun onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()){
            super.onBackPressed()
            finish()
        }else{
            Toast.makeText(this,"Press Back Again",Toast.LENGTH_SHORT).show()
        }
        backPressedTime = System.currentTimeMillis()
    }

}