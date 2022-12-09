package com.example.to_do

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.Toast

class WebBrowse : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_browse)
        val edtText:EditText? = findViewById(R.id.editText)
        val button:Button = findViewById(R.id.btn)
        button.setOnClickListener{
            try {
                if (edtText?.length()!! >0){
                    val url = edtText.text.toString()
                    val urlIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                    startActivity(urlIntent)
                } else{
                    Toast.makeText(this,"Please Enter url...!",Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
            } catch (e:java.lang.NullPointerException){
                e.printStackTrace()
            }
        }
    }

    override fun onBackPressed() {
        finish()
        val switch = findViewById<Switch>(R.id.switchBrowser)
        switch.isChecked = false
    }
}