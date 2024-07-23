package com.example.q1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextNumber1 = findViewById<EditText>(R.id.editTextNumber1)
        val editTextNumber2 = findViewById<EditText>(R.id.editTextNumber2)
        val buttonAdd = findViewById<Button>(R.id.buttonAdd)
        val buttonSubtract = findViewById<Button>(R.id.buttonSubtract)
        val buttonMultiply = findViewById<Button>(R.id.buttonMultiply)
        val buttonDivide = findViewById<Button>(R.id.buttonDivide)
        val textViewResult = findViewById<TextView>(R.id.textViewResult)

        fun calculateResult(operation: String): String {
            val number1 = editTextNumber1.text.toString().toDoubleOrNull() ?: 0.0
            val number2 = editTextNumber2.text.toString().toDoubleOrNull() ?: 0.0
            return when (operation) {
                "add" -> "Addition of numbers: ${number1 + number2}"
                "subtract" -> "Subtraction of numbers: ${number1 - number2}"
                "multiply" -> "Multiplication of numbers: ${number1 * number2}"
                "divide" -> if (number2 != 0.0) {
                    "Division of numbers: ${number1 / number2}"
                } else {
                    "Cannot divide by zero"
                }
                else -> "Invalid operation"
            }
        }

        buttonAdd.setOnClickListener {
            textViewResult.text = calculateResult("add")
        }

        buttonSubtract.setOnClickListener {
            textViewResult.text = calculateResult("subtract")
        }

        buttonMultiply.setOnClickListener {
            textViewResult.text = calculateResult("multiply")
        }

        buttonDivide.setOnClickListener {
            textViewResult.text = calculateResult("divide")
        }
    }
}