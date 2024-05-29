package com.example.tutorial03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var name:EditText
    lateinit var btnWelcome:Button
    lateinit var btnBye:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        name=findViewById(R.id.editTextText)
        btnWelcome=findViewById(R.id.buttonWelcome)
        btnBye= findViewById(R.id.btnGoodBye)

        btnWelcome.setOnClickListener {
            sayWelcome();
        }

        btnBye.setOnClickListener {
            sayBye();
        }


    }

    private fun sayBye() {
        Toast.makeText(this,"Hello, Good Bye ${name.text.toString()}",Toast.LENGTH_LONG).show();
    }

    fun sayWelcome(){
        Toast.makeText(this,"Hello, Welcome ${name.text.toString()}",Toast.LENGTH_LONG).show();
    }
}