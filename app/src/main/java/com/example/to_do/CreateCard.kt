package com.example.to_do

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_create_card.*

class CreateCard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_card)
        saveButton.setOnClickListener{
            if (createTitle.text.toString().trim{it<=' '}.isNotEmpty()
                && createPriority.text.toString().trim{it<= ' '}.isNotEmpty())
            {
                val title = createTitle.text.toString()
                val priority = createPriority.text.toString()
                DataObject.setData(title, priority)
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
            }
        }
    }
}