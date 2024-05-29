package com.example.tutorial04_calculator.models

class Calculator(private val number1:Double, private  val number2:Double) {
    fun add() = number1+number2
    fun sub() = number1-number2
    fun mul() = number1*number2
    fun div() = number1/number2
}