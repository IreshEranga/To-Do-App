package com.example.tutorial04_calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import android.widget.Toast.*
import com.example.tutorial04_calculator.models.Calculator

class MainActivity : AppCompatActivity() {
    lateinit var number1:EditText
    lateinit var number2:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        number1 = findViewById(R.id.editTextNumber1)
        number2 = findViewById(R.id.editTextNumber2)

    }

    fun buttonClick(v:View){

        var ans = 0.0
         val calc = Calculator(
             number1.text.toString().toDouble(),
             number2.text.toString().toDouble()
         )

        when(v.id){
            R.id.buttonPlus -> ans = calc.add()
            R.id.buttonMinus -> ans = calc.sub()
            R.id.buttonmul -> ans = calc.mul()
            R.id.buttondiv -> ans = calc.div()
        }

        Toast.makeText(this,"Answer = $ans", Toast.LENGTH_LONG).show()
    }


}