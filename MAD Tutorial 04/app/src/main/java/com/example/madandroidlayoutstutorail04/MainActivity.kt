package com.example.madandroidlayoutstutorail04

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var edtName:EditText
    private lateinit var welcomebtn:Button
    private lateinit var byebtn:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        edtName = findViewById(R.id.edtName)
        welcomebtn = findViewById(R.id.welcomebtn)
        byebtn = findViewById(R.id.byebtn)

        //calling function when btn click
        welcomebtn.setOnClickListener {
            welcome()
        }

        byebtn.setOnClickListener {
            goodBye()
        }
    }

    private fun welcome(){
        Toast.makeText(this,"${getText(R.string.msg1)} ${edtName.text}", Toast.LENGTH_LONG).show()
    }

    private fun goodBye(){
        Toast.makeText(this,"${getText(R.string.msg2)} ${edtName.text}", Toast.LENGTH_LONG).show()
    }

}